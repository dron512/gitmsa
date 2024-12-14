const bcrypt = require('bcrypt');
const passport = require('passport');
const User = require('../models/user');

exports.join = async (req, res, next) => {
    const {email, nick, password} = req.body;
    try {
        const exUser = await User.findOne({where: {email}});
        if (exUser) {
            return res.redirect('/join?error=exist');
        }

        const hash = await bcrypt.hash(password, 12);
        await User.create({
            email,
            nick,
            password: hash,
        })
        return res.redirect('/');
    } catch (err) {
        console.log(err);
        return next(err);
    }
}

exports.login = (req, res, next) => {
    console.log(req.body);

    passport.authenticate('local', (err, user, info) => {
        if (err) {
            console.error(err);
            return next(err);
        }
        if (!user) {
            return res.redirect(`/?error=${info.message}`);
        }
        return req.login(user, (loginError) => {
            if (loginError) {
                console.error(loginError);
                return next(err);
            }
            return res.redirect('/');
        })
    })(req, res, next);
}

exports.logout = (req,res) => {
    req.logout(()=>{
        res.redirect('/');
    });
}