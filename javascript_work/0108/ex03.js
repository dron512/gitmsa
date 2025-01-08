const aa = {
  a: "a변수입니다.",
  b: "bbbb는 20입니다",
  c: "c변수입니다.",
};

const { a, b, c } = aa;

console.log(`a = ${a.toString()}`);
console.log(`b = ${b}`);
console.log(`c = ${c}`);
console.log(aa);

// 탄탄회사 오래된회사
// 50 ~ 60%  
// jquery -> ajax();json 비동기 통신

// 신규개발
// javascript -> vue
// javascript -> react -> 
// Node -> typescript -> next.js axiosX fetch()O
// 문자열로 만드는 함수 JSON.stringify();
// 문자열을 다시 객체로 만드는 함수 JSON.parse();
const aaa = JSON.stringify(aa);
console.log(JSON.parse(aaa));