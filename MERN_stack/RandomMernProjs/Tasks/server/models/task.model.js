const mongoose = require('mongoose');
const TaskSchema = new mongoose.Schema({
    title: {
        type: String,
        required: [true, "Title is required"],
        unique: [true, "Task should be Unique"],
        minlength: [2, "Title should be at least 2 characters"]
    },
    date: {
        type: Date,
        required:[true, "Date is required"],
        min: '1987-09-28',
    },
    status: { type: String, 
                default:"To Do",}

}, { timestamps: true });
module.exports.Task = mongoose.model('Task', TaskSchema);
