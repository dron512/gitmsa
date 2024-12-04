const express = require('express');
const passport = require('passport');

const test = require('../middlewares/test');

console.log(test+"test");
console.log(test.bb+"test");
test.aa();

const {isLoggedIn, isNotLoggedIn} = require('../middlewares');
const {join, login, logout} = require('../controllers/auth');

const router = express.Router();

router.post('/join', isNotLoggedIn, join);
router.post('/login', isNotLoggedIn, login);

router.get('/logout', isLoggedIn, logout);

router.get('/kakao',passport.authenticate('kakao'));

router.get('/kakao/callback',passport.authenticate('kakao',{
    failureRedirect:'/?error=카카오로그인 실패',
}), (req, res) => {
    res.redirect('/');
})

module.exports = router;