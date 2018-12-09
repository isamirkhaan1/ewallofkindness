module.exports = (app) => {
    const user = require('../controllers/user.controller')
    app.post('/login', user.Login);
    app.post('/signup', user.Signup);
}