const express = require('express');
const Comment  = require('../models/comment');
const User = require("../models/user");

const router = express.Router();

router.post('/', async (req, res,next) => {
    try{
        console.log(req.body);
        const comments = await Comment.create({
            commenter : req.body.id,
            comment: req.body.comment,
        })
        console.log(comments);
        res.status(201).json(comments);
    }
    catch (err){
        console.log(err);
    }

})

module.exports = router;
