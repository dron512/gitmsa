const express = require('express');
const User = require('../models/user');

const router = express.Router();

router.get('/', async (req, res,next) => {
    console.log("일로오나");
    try{
        const users = await User.findAll();
        console.log(users);
        res.render('index', { users });
    }catch(err){
        console.error(err);
        next(err);
    }
});

module.exports = router;