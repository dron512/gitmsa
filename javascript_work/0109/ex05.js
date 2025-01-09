setTimeout(() => {
  console.log("test")
}, 3000);

setTimeout(() => {
  console.log("2초뒤에")
}, 2000);

const aa = setInterval(()=>{
  console.log("2초마다")
},2000)

setTimeout(()=>{
  clearInterval(aa);
},8000);

console.log("출력됩니다.");