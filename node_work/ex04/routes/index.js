const express = require('express');

const router = express.Router();

router.get('/', async (req, res,next) => {
    console.log("일로오나");
    try{
        res.render('index');
    }catch(err){
        console.error(err);
        next(err);
    }
});

module.exports = router;