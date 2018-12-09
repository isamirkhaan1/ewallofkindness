const User = require('../models/user.model');
const jwt = require('jsonwebtoken');
const key = require('../../config/db.config').secret;

var token = jwt.sign({ foo: 'bar' }, key, { expiresIn: '365d' });


exports.Login = (req, res) => {
    User.findOne({
        phone_no: req.body.phone_no
    })
    .then(data => {
            if (!data) {
               return res.status(200).send({
                    status: false,
                    message: "User not found"
                })
            } else {
                return res.status(200).send({
                    status: true,
                    data: data, 
                    token: token
                })
            }
        })
    .catch(err => {
           return res.status(200).send({
                status: false,
                message: err.message
            })
        })
}

// Create and Save a new User
exports.Signup = (req, res) => {
    console.log(req.body);
    
    // Create a User
    const user = new User({
        name: req.body.name, 
        phone_no: req.body.phone_no, 
        donation_amount: req.body.donation_amount
    });

    // Save User in the database
    user.save()
        .then(data => {
            return res.send({
                status: true,
                data: data, 
                token: token
            });
        })
        .catch(err => {
            return res.status(200).send({
                status: false,
                message: err.message || "Some error occurred while creating the User. "
            });
        });
}