const express = require("express");
const User = require("../models/user");
const Comment = require("../models/comment");

const router = express.Router();

router.route("/")
    .get(async (req, res, next) => {
        try {
            const users = await User.findAll();
            res.json(users);
        } catch (err) {
            console.log(err);
            next(err);
        }
    })
    .post(async (req, res, next) => {
        try{
            const newUser = await User.create({
                name: req.body.name,
                age: req.body.age,
                married: req.body.married,
            });
            console.log(newUser);
            res.status(201).json(newUser);
        }catch (err){
            console.error(err);
            next(err);
        }
    })
router.get("/:id/comments",async (req, res, next) => {
    try{
        const comments = await Comment.findAll({
            where:{ commenter: req.params.id },
            include: {
                model: User,
                attributes: {'id':req.params.id},
            }
        });
        console.log(comments);
        res.json(comments);
    }catch (err){
        console.error(err);
        next(err);
    }
})

module.exports = router;