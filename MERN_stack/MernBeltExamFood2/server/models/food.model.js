const mongoose = require('mongoose');
const FoodSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "Name is required"],
        minlength: [4, "Food Name should be at least 4 characters"]
    },
    img: {
        type: String,
        required: [true, "Img url is required"],
    },
    kitchen: {
        type: String,
        required: [true, "Kitchen is required"],
    },
    recipe: {
        type: String,
        required: [true, "Recipe is required"],
    }


}, { timestamps: true });
module.exports.Food = mongoose.model('Food', FoodSchema);
