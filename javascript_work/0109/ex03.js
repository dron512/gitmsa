// 배열 map-> 반환되는 값이 있는 경우, foreach-> 반환되는 값이 없는경우

// 문제가
function aa(){}

const arr1 = [1,2,3];

const mapArr1 = arr1.map(item=> { 
  console.log("map 돌아갑니다");
  return item*3;
} );

const foreachArr1 = arr1.forEach(item=>{ item*3 } );

console.log('mapArr1');
console.log(mapArr1);

console.log('foreachArr1');
console.log(foreachArr1);

