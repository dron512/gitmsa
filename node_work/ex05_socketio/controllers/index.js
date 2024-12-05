const Room = require('../schemas/room');
const Chat = require('../schemas/chat');

exports.renderMain = async (req, res, next) => {
    try{
        const rooms = await Room.find();
        res.render('main', { rooms: rooms , title: 'GIF 채팅방' });
    }catch (err){
        console.error(err);
        next(err);
    }
}

exports.renderRoom = async (req, res, next) => {
    res.render('room',{title:'GIF 채팅방 생성'});
}

exports.createRoom = async (req, res, next) => {
    try{
        const newRoom = await Room.create({
            title: req.body.title,
            max: req.body.max,
            owner: req.session.owner,
            password: req.body.password,
        })
        const io = req.app.get('io');
    }catch (err){
        console.error(err);
        next(err);
    }
}