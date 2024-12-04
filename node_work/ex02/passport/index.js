const passport = require('passport');
const local = require('./localStrategy.js');
const kakao = require('./kakaoStrategy.js');


const User = require('../models/user');

module.exports = () => {
    // 로그인시 실행되며,
    passport.serializeUser((user, done) => {
        const { stringify } = require('flatted');
        console.log('User model:', stringify(user));
        done(null, user.id);
    });
    passport.deserializeUser((id, done) => {
        User.findOne({where: {id}})
            .then((user) => {
                done(null, user)
            })
            .catch(err => done(err));
    })

    local();
    kakao();
}

