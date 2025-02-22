const express = require('express');
const router = express.Router();
const Room = require('../schemas/room');
const Chat = require('../schemas/chat');
const multer = require('multer');
const path = require('path');
const fs = require('fs');
const { promisify } = require('util');
const sizeOf = promisify(require('image-size'));

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
    const room = await Room.findOne({_id: req.params.id});
    const chats = await Chat.find({room: room._id}).sort('createdAt');
    const {rooms} = req.app.get('io').of('/chat').adapter;
    res.render('chat',
        {
            room,
            chats,
            password: req.query.password,
            user: req.session.color
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

router.post('/upload/:id', upload.single('gif'), async (req, res, next) => {
    const filePath = req.file.path; // 업로드된 파일 경로
    const dimensions = await sizeOf(filePath);
    console.log('Width:', dimensions.width);
    console.log('Height:', dimensions.height);
    try {
        const chat = await Chat.create({
            room: req.params.id,
            user: req.session.color,
            gif: req.file.filename,
            gif_height: dimensions.height,
        });
        req.app.get('io').of('/chat').to(req.params.id).emit('chat', chat);
        res.json({success: true, msg: req.body.file});
    } catch (err) {
        console.log(err);
    }
})

module.exports = router;