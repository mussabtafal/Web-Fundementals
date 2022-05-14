const foodController = require('../controllers/food.controller');
module.exports = function (app) {
    app.get('/api', foodController.index);
    app.post('/api/foods', foodController.createFood);
    app.get('/api/foods', foodController.getAllFoods);
    app.get('/api/foods/:id', foodController.getFood);
    app.put('/api/foods/:id', foodController.updateFood);
    app.delete('/api/foods/:id', foodController.deleteFood);


}
