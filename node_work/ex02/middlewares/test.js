const test = require("node:test");
module.exports = {
    test:"test",
    aa:(test)=>{
        console.log("aa function test");
        if (test)
            test();
    }
}