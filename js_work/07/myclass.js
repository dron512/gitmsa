export default {
  a: 10,
  b: function () {
    console.log('test');
  }
};

export const aa = {
  z:10,
  zz:20,
  zzz:function(){ console.log("test"); }
};

export const bb = ()=>{
  let a = 10;
  let b = 20;

  console.log("bb");

  let c = 30;
  return 10;
}
// let const ???? javascript 컴파일라가 알아서.. 처리...
export const cc = function (a,b){

  // return "asdf";
  return 10;
}

// alt +shift + f 자동 정렬