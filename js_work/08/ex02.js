import {aa,bb} from './myclass.js'

console.log(aa);
console.log(aa.a);
console.log(aa.b);

aa.b();
const {a,b} = aa;
console.log(`a = ${a}`);
console.log(`b = ${b}`);

const [qwer,asdf] = bb;
console.log(`qwer = ${qwer}`);
console.log(`asdf = ${asdf}`);
