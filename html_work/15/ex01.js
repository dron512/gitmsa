const aa = document.getElementById("btn-min");
const bb = document.getElementById("btn-max");
const printDiv = document.getElementById("print-div");

const n1 = document.getElementById("num1");
const n2 = document.getElementById("num2");
const n3 = document.getElementById("num3");
const n4 = document.getElementById("num4");
const n5 = document.getElementById("num5");

function min() {
    const arr = [n1.value, n2.value, n3.value, n4.value, n5.value];
    let min = arr[0];
    for (let index = 0; index < arr.length; index++) {
        const element = arr[index];
        if (Number(min) > Number(element))
            min = element;
    }
    printDiv.textContent = "최솟값 = " + min;
}
function max() {
    const arr = [n1.value, n2.value, n3.value, n4.value, n5.value];
    let max = arr[0];
    for (const key of arr) {
        if (Number(max) < Number(key))
            max = key;
    }
    printDiv.textContent = "최댓값 = " + max;
}

aa.addEventListener('click', min);
bb.addEventListener('click', max);






const cc = 10;
let dd = 10;

// 이거 에러... 못바꿈
// cc = 20;

dd = 30;

// console.log(dd);

for (let i = 0; i < 10; i++) {
    // console.log(i);
}
