const express = require('express');
const {renderProfile, renderJoin, renderMain} = require('../controllers/page');
const {isLoggedIn, isNotLoggedIn} = require("../middlewares");
const passport = require('passport');
const req = require("express/lib/request");

const router = express.Router();

router.use((req, res, next) => {
    res.locals.user = req.user;
    res.locals.followerCount = 0;
    res.locals.followingCount = 0;
    res.locals.followingIdList = [];
    next();
})

router.get('/profile', isLoggedIn, renderProfile);
router.get('/join', isNotLoggedIn, renderJoin);
router.get('/', renderMain);

module.exports = router;