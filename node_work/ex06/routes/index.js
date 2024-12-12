const express = require('express');
const router = express.Router();
const Room = require('../schemas/room');
const Chat = require('../schemas/chat');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

router.get('/', async (req, res, next) => {
    try {
        const rooms = await Room.find({});
        res.render('index', {rooms});
    } catch (error) {
        console.error(error);
        next(error);
    }
})

router.post('/', async (req, res, next) => {
    console.log("room으로 왔음");
    try {
        const newRoom = await Room.create({
            title: req.body.title,
            max: req.body.max,
            owner: req.session.color,
            password: req.body.password,
        })
        const io = req.app.get('io');
        io.of('/room').emit('newRoom', newRoom);
        console.log(newRoom._id);
        res.json({success: true, id: newRoom._id});
        // if(req.body.password){
        //     res.redirect(`/room/${newRoom._id}?password=${req.body.password}`);
        // }else{
        //     res.redirect(`/room/${newRoom._id}`);
        // }
    } catch (err) {
        console.log(err);
        next(err);
    }
})

router.get('/chat/:id', async (req, res, next) => {
    const {rooms} = req.app.get('io').of('/chat').adapter;
    console.log(rooms);
    console.log(rooms, rooms.get(req.params.id), rooms.get(req.params.id));
    res.render('chat',
        {
            room: req.params.id,
            password: req.query.password,
            user: req.session.user
        });
})

try {
    fs.readdirSync('uploads');
} catch (err) {
    console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
    fs.mkdirSync('uploads');
}

const upload = multer({
    storage: multer.diskStorage({
        destination(req, file, done) {
            done(null, 'uploads/');
        },
        filename(req, file, done) {
            const ext = path.extname(file.originalname);
            done(null, path.basename(file.originalname, ext) + Date.now() + ext);
        },
    }),
    limits: {fileSize: 5 * 1024 * 1024},
});


router.post('/chat/:id', upload.none(), async (req, res, next) => {
    try {
        const chat = await Chat.create({
            room: req.params.id,
            chat: req.body.msg,
            user: req.session.color,
        });
        req.app.get('io').of('/chat').to(req.params.id).emit('chat', chat);
        res.json({success: true, msg: req.body.msg});
    } catch (err) {
        console.log(err);
    }
})

router.post('/chat', upload.single('gif'), async (req, res, next) => {
    try {
        console.log(req.body.msg);
        res.json({success: true, msg: req.body.msg});
    } catch (err) {
        console.log(err);
    }
})

module.exports = router;