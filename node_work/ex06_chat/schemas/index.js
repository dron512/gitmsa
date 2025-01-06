const mongoose = require('mongoose');

const {MONGO_ID, MONGO_PASSWORD, MONGODB_URL} = process.env;
const username = MONGO_ID;
const password = encodeURIComponent(MONGO_PASSWORD);
const url = encodeURIComponent(MONGODB_URL);

// const URL = `mongodb+srv://${username}:${password}/${url}`;

const URL = `mongodb+srv://${username}:${password}@${url}?retryWrites=true`

const connect = async () => {
    // if (NODE_ENV !== 'production') {
    mongoose.set('debug', true);
    // }
    await mongoose.connect(URL, {
        dbName: 'gifchat',
    }).then(() => {
        console.log('몽고디비 연결 성공');
    }).catch((err) => {
        console.log(err);
    })
};

mongoose.connection.on('error', (err) => {
    console.error('몽고디비 연결 에러',err)
})

mongoose.connection.on('disconnect', () => {
    console.error('몽고디비 연결이 끊겼습니다. 연결을 재시도 합니다.');
    connect();
})

module.exports = connect;
