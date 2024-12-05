const mongoose = require('mongoose');

const { MONGO_ID, MONGO_PASSWORD } = process.env;
const MONGODB_URL = `mongodb+srv://${MONGO_ID}:${MONGO_PASSWORD}/${MONGODB_URL}`;