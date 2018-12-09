const ImageSchema = require('../models/image_model');

exports.uploadImage = (req, res) => {

    array = [];

    for (var i = 0; i < req.files.length; i++) {
        image = new ImageSchema({
            donate_id: req.body.donate_id,
            image_path: [
                {
                    originalname: req.files[i].originalname,
                    filename: req.files[i].filename,
                    path: req.files[i].path
                }
            ]
        })
        .save()
        .then(data => {
            array.push(data.status);
            if (array.length === req.files.length) {
                return res.status(200).send({
                    status: true,
                    message: "Image uploaded successfully"
                });
            }
        })
        .catch(err => {
            res.status(200).send({
                status: false,
                message: err.message
            })
        })
    }
}
