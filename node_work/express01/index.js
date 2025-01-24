const express = require("express");

const db = require('./db');

const app = express();
app.use(express.json()); // json 파일 번역해서 req 에 달아주는 역활

app.get("/", (req, res) => {
  res.send("hello");
});

app.get("/aa", (req, res) => {
  const name = "홍길동";
  const age = 20;
  res.send({ name, age });
});

app.post("/save", (req, res) => {
  console.log("save 온다");
  res.json({ status: 200, message: "success" });
});

app.post("/login", (req, res) => {
  db.select();
  console.log(req.body);
  res.json({ status: 200 });
});

app.listen(3000, () => {
  console.log("3000번으로 서버시작했음");
});
