const express = require("express");
require("dotenv").config();

const path = require("path");
const morgan = require("morgan");
const nunjucks = require("nunjucks");

const connect = require("./schemas");
const indexRouter = require("./routes/index");

connect();

const app = express(); // Express 앱 생성
const port = 4999; // 서버가 실행될 포트 번호


app.use('/',indexRouter);

app.use( (req,res,next)=>{
  const error = new Error(`Error: ${req.method} ${req.url} 라우터가 없습니다.`);
  error.status = 404;
  next(error);
})

app.use((err,req, res, next)=>{
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development'? err : {};
  res.status(err.status || 500);
  res.render('error');
})


app.listen(port, "0.0.0.0", () => {
  console.log(`Server is running at http://localhost:${port}`);
});
