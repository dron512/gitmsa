const passport = require('passport');
// const local = require('./localStrategy.js');
// const kakao = require('./kakaoStrategy.js');


const User = require('../models/User');

module.exports = () => {
    // 로그인시 실행되며,
    passport.serializeUser((user, done) => {
        done(null, user.id);
    });
    passport.deserializeUser((id, done) => {
        User.findOne({where: {id}})
            .then((user) => {
                done(null, user)
            })
            .catch(err => done(err));
    })

    // local();
}

