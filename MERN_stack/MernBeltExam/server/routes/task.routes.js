const taskController = require('../controllers/task.controller');
module.exports = function (app) {
    app.get('/api', taskController.index);
    app.post('/api/tasks', taskController.createTask);
    app.get('/api/tasks', taskController.getAllTasks);
    app.get('/api/tasks/:id', taskController.getTask);
    app.put('/api/tasks/:id', taskController.updateTask);
    app.delete('/api/tasks/:id', taskController.deleteTask);


}
