const mongoose = require('mongoose');

var ImageSchema = mongoose.Schema({
    donate_id: mongoose.Schema.ObjectId, 
    image_path: [
        {
            originalname: String, 
            filename: String, 
            path: String
        }
    ]
})

module.exports = mongoose.model("image", ImageSchema);