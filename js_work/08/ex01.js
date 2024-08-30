//module export import 함수 호출 하고 객체로 가져오고
import qqq, { doA, doB } from './myfunction.js';

console.log('test');
doA();
doB();

console.log(`qqq.a = ${qqq.a}`);
console.log(`qqq.b = ${qqq.b}`);