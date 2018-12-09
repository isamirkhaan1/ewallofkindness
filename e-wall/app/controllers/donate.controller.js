const DonateSchema = require('../models/donate.model');

exports.createDonate = (req, res) => {
    console.log(req.body);
    
    const donate = new DonateSchema({
        cat_name: req.body.cat_name,
        location: req.body.location,
        price: req.body.price,
        description: req.body.description,
        user_id: req.body.user_id
    });

    donate.save()
        .then(data => {
            return res.status(200).send({
                status: true,
                data: data
            })
        })
        .catch(err => {
            return res.status(200).send({
                status: false,
                message: err.message
            })
        })
}

exports.getDonation = (req, res) => {
    DonateSchema.find({
        location: req.params.location
    })
        .then(data => {
            DonateSchema.aggregate([
                {
                    $lookup:
                    {
                        from: "images",
                        localField: "_id",
                        foreignField: "donate_id",
                        as: "Images"
                    }
                }
            ]).exec(function (err, result) {
                if (result) {
                    return res.status(200).send({
                        status: true,
                        data: result
                    })
                }

                else if(err) {
                    return res.status(200).send({
                        status: false,
                        message: err.message
                    })
                } else {
                    return res.status(200).send({
                        status: false,
                        message: "No record found"
                    })
                }
            });
        })
        .catch(err => {
            return res.status(200).send({
                status: false,
                message: err.message
            })
        })
}