const WebSocket = require('ws');

module.exports = (server) => {
    // console.log(server);
    const wss = new WebSocket.Server({server});

    wss.on('connection', (ws, req) => {
        console.log(req.headers['x-forwarded-for']);
        console.log(req.socket.remoteAddress);
        const ip = req.socket.remoteAddress;
        ws.on('message', (msg) => {
            console.log(msg.toString());
        })
        ws.on('error', (err) => {
            console.log(err);
        })
        ws.on('close', () => {
            console.log('클라이언트 접속해제'+ip)
            clearInterval(ws.interval);
        })
        ws.interval = setInterval(() => {
            if(ws.readyState === ws.OPEN){
                ws.send('서버에서 클라이언트로 메시지를 보냅니다.');
            }
        },3000)
    })
}