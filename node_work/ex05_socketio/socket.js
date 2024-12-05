const SocketIO = require('socket.io');

module.exports = (server) => {
    // console.log(server);
    const io = SocketIO(server, {path: '/socket.io'});

    io.on('connection', (socket) => {
        const req = socket.request;
        // console.log('==================================\n', req);
        const ip = req.socket.remoteAddress;
        console.log(`새로운 클라이언트 접속 ${ip}`);
        socket.on('disconnect', () => {
            console.log('클라이언트 접속 해제', ip, socket.ip, socket.id);
            clearInterval(socket.interval);
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
}