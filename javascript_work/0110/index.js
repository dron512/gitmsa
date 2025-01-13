// common.js -> require 
// module.js -> import from
// System.out.println();
// const process = new Process();
import dotenv from 'dotenv';
dotenv.config();

// require('dotenv').config()

console.log(process.env.NODE_ENV);