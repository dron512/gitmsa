const express = require('express');
const path = require('path');
const morgan = require('morgan');

const nunjucks = require('nunjucks');
const {sequelize} = require('./models');

const indexRouter = require('./routes');
const userRouter = require('./routes/user');
const commentRouter = require('./routes/comments');

sequelize.sync({force: false})
    .then(() => {
        console.log("데이터베이스 연결성공")
    })
    .catch((err) => {
        console.error(err)
    })

const app = express();
app.set('port', process.env.PORT || 3001);
app.set('view engine', 'html');
nunjucks.configure("views", {
    express: app,
    watch: true,
})

app.use(morgan('dev'));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.json());
app.use(express.urlencoded({extended: false}));

app.use('/', indexRouter);
app.use('/users', userRouter);
app.use('/comments', commentRouter);

app.use((req, res, next) => {
    const error = new Error('Not Found!');
    error.status = 404;
    next(error);
})

app.use((err, req, res, next) => {
    res.locals.message = err.message;
    res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};
    res.status(err.status || 500);
    res.render('error');
})

app.listen(app.get('port'), () => {
    console.log("Server started on port: " + app.get('port'));
})