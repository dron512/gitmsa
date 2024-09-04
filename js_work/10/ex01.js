const arr = ['a','b','c'];
const brr = [1,2,3,4,5];

const str1 = arr.join();
const str2 = brr.join('<p>');

console.log(str1);
console.log(str2);

// push arr 제일끝에 값이 추가되고... 배열의 길이값이 반환된다...
const length = arr.push('zz');
console.log(arr);
console.log(length);

// unshift arr 제일앞에 값이 추가되고... 배열의 길이값이 반환된다...
const value = arr.unshift('aa');
console.log(arr);
console.log(value);

const item = arr.pop();
console.log(item);
console.log(arr);

const fitem = arr.shift();
console.log(fitem);
console.log(arr);

