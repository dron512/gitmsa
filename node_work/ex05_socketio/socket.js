const SocketIO = require('socket.io');
const {removeRoom} = require("./controllers");

module.exports = (server, app, sessionMiddleware) => {
    const io = SocketIO(server, {path: '/socket.js.io'});

    app.set('io', io);

    const room = io.of('/room');
    const chat = io.of('/chat');

    const wrap = middleware => (socket, next) => {
        middleware(socket.request, {}, next);
    }

    chat.use(wrap(sessionMiddleware));

    room.on('connection', (socket) => {
        console.log('room 네임스페이스 접속');
        socket.on('disconnect', () => {
            console.log('room 네임스페이스 접속 해제')
        })
    })

    chat.on('connection', (socket) => {
        console.log('chat 네임스페이스에 접속');

        socket.on('join', (data) => {
            socket.join(data);
            socket.to(data).emit('join', {
                user: 'system',
                // chat: `${socket.js.request.session.color}님이 입장하셨습니다.`
                chat: "test입니다"
            });
        });
        socket.on('disconnect', async () => {
            console.log('chat 네임스페이스 접속 해제');

            const {referer} = socket.request.headers;
            console.log(referer);
            const roomId = new URL(referer).pathname.split('/').at(-1);
            console.log(`roomId = ${roomId}`);
            const currentRoom = chat.adapter.rooms.get(roomId);
            console.log(`currentRoom ${currentRoom}`);
            const userCount = currentRoom?.size || 0;
            if (userCount === 0) {
                await removeRoom(roomId);
                room.emit('removeRoom', roomId);
                console.log('방 제거 요청 성공');
            } else {
                socket.to(roomId).emit('exit', {
                    user: 'system',
                    chat: `${socket.request.session.color}님이 퇴장하셨습니다.`
                })
            }
        })
    })
}