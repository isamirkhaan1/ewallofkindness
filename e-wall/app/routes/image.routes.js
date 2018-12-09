const middleware = require('../middleware/verify_token.middleware');
const multer = require('multer');
const storage = multer.diskStorage({
    destination: function (req, file, callback) {
        callback(null, '././images');
    },
    filename: function (req, file, callback) {
        callback(null, file.originalname);
    }

});
const upload = multer(
    { storage: storage },
    { limits: 1024 * 1024 * 5 }
);
var type = upload.array('image_path');


module.exports = (app) => {
    const image = require('../controllers/image.controller')
    app.post('/image', middleware.jwtVerify, type, image.uploadImage);
}