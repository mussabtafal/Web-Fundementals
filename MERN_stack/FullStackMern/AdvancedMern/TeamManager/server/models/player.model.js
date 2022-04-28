const mongoose = require('mongoose');
const TeamSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [
            true,
            "Player Name is required"
        ],
        minlength: [
            2,
            "Player Name must be at least 2 characters"
        ]
    },
    position: { type: String },
    gameOne: { type: String, default: "undecided" },
    gameTwo: { type: String, default: "undecided" },
    gameThree: { type: String, default: "undecided" },
}, { timestamps: true });
module.exports.Player = mongoose.model('Player', TeamSchema);
