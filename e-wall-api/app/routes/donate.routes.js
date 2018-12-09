const middleware = require('../middleware/verify_token.middleware');


module.exports = (app) => {
    const donate = require('../controllers/donate.controller')
    app.post('/donate', middleware.jwtVerify, donate.createDonate);

    app.get('/donate/:location', middleware.jwtVerify, donate.getDonation);
}