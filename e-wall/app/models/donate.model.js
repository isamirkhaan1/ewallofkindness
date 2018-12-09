const mongoose = require('mongoose');

var DonateSchema = mongoose.Schema({
    cat_name: {
        type: String,
        required: true, 
        trim: true
    },
    location: String,
    price: {
        type: String,
        default: "0.00"
    },
    description: {
        type: String,
        required: true, 
        trim: true
    }, 
    user_id: String

},
    {
        timestamps: true
    }
);


module.exports = mongoose.model("donate", DonateSchema);