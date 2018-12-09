const mongoose = require('mongoose');

const UserSchema = mongoose.Schema({
    name: {
        type: String, 
        required: true
    }, 
    phone_no: {
        type: String,
        unique: true,
        required: true
    }, 
    donate_amount: {
        type: Number, 
        default: 0
    }
}, {
    timestamps: true
});


module.exports = mongoose.model('user', UserSchema);