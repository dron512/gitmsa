const passport = require('passport');
const KakaoStrategy = require('passport-kakao').Strategy;

const User = require('../models/user');

module.exports = () => {
    passport.use(new KakaoStrategy({
        clientID: process.env.KAKAO_CLIENT_ID,
        clientSecret: process.env.KAKAO_CLIENT_SECRET,
        callbackURL: process.env.KAKAO_CLIENT_CALLBACK_URL,
    }, async (accessToken, refreshToken, profile, done) => {
        console.log('kakao Profile', profile);
        try {
            const exUser = await User.findOne({
                where: {snsId: profile.id, provider: 'kakao'}
            })
            if (exUser) {
                done(null, exUser);
            } else {
                const newUser = await User.create({
                    email: profile._json?.kakao_account?.email,
                    nick: profile._json?.properties.nickname,
                    snsId: profile.id,
                    provider: 'kakao',
                })
                done(null, newUser);
            }
        } catch (err) {
            console.log(err);
        }
    }))
}