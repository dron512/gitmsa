const mongoose = require("mongoose");

const connect = () => {

  if (process.env.NODE_ENV !== "production") {
    mongoose.set("debug", true);
  }
  mongoose
    .connect(process.env.MONGODB_URI, {
      useNewUrlParser: true,
      useUnifiedTopology: true,
      dbName: process.env.MONGODB_NAME,
    })
    .then(() => {
      console.log("Connected to Mongoose");
    })
    .catch((err) => {
      console.error("Error connecting to Mongoose", err);
    });
};

mongoose.connection.on("error", (err) => {
  console.error("Error connecting to Mongoose", err);
});

mongoose.connection.on("disconnected", () => {
  console.log("Mongoose disconnected");
});

module.exports = connect;