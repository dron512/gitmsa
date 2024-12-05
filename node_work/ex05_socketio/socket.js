const SocketIO = require('socket.io');

module.exports = (server, app) => {
    // console.log(server);
    const io = SocketIO(server, {path: '/socket.io'});

    app.set('io', io);

    const room = io.of('/room');
    const chat = io.of('/chat');

    room.on('connection', (socket) => {
        console.log('room 네임스페이스 접속');
        const req = socket.request;
        // console.log('==================================\n', req);
        // const ip = req.socket.remoteAddress;
        socket.on('disconnect', () => {
            console.log('room 네임스페이스 접속 해제')
            // clearInterval(socket.interval);
        })
        socket.on('error', (err) => {
            console.log(err);
        })
        socket.on('reply', (data) => {
            console.log(data);
        })

        socket.interval = setInterval(() => {
            socket.emit('message', 'hello socketio');
        }, 1000)
    })

    chat.on('connection', (socket) => {
        console.log('chat 네임스페이스에 접속');

        socket.on('join', (data) => {
            socket.join(data);
        });
        socket.on('disconnect', () => {
            console.log('chat 네임스페이스 접속 해제');
        })
    })
}