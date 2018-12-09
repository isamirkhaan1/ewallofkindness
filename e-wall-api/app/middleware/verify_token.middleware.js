var jwt = require('jsonwebtoken');
const secretKey = require("../../config/db.config").secret;


function jwtVerify(req, res, next) {

    // getting token 
    let token = req.body.token ||
        req.query.token ||
        req.headers['x-access-token'];
        

    if (!token) {
        try {
            token = req.headers.authorization.split(' ')[1];
        } catch (e) {
            console.log("token not found in any given params")
        }
    }


    jwt.verify(token, secretKey, (err, authData) => {
        if (err) {
            return res.status(200).send({
                success: false,
                error: true,
                message: err
            });

        } else {
            console.log('executing next...');
            next();
        }
    });

}

module.exports = {
    jwtVerify: jwtVerify
}

