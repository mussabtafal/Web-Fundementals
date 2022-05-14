const { Food } = require('../models/food.model');
module.exports.index = (request, response) => {
    response.json({
        message: "Hello World"
    });
}
// The method below is new
module.exports.createFood = (request, response) => {
    const { name, img, kitchen, recipe} = request.body;
    Food.create({
        name,
        img,
        kitchen,
        recipe
    })
        .then(food => response.json(food))
        .catch(err => response.status(400).json(err))
}

module.exports.getAllFoods = (request, response) => {
    Food.find({})
        .then(foods => response.json(foods))
        .catch(err => response.json(err))
}

module.exports.getFood = (request, response) => {
    Food.findOne({ _id: request.params.id })
        .then(food => response.json(food))
        .catch(err => response.json(err))
}

module.exports.updateFood= (request, response) => {
    Food.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
        .then(updatedFood => response.json(updatedFood))
        .catch(err => response.json(err))
}

module.exports.deleteFood = (request, response) => {
    Food.deleteOne({ _id: request.params.id })
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.json(err))
}


