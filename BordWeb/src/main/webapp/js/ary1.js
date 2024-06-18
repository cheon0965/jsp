/**
 *  ary1.js
 *  forEach, fillter, map, reduce
 */

const numAry = [23, 17, 5, 41, 30];
result = 0;
let evenSum = function(elem, idx, ary) {
    if(elem % 2 == 0){
        result += elem;
    }
}; // 매개값으로 함수.

let oddSum = function(elem, idx, ary) {
    if(idx % 2 == 0){
        result += elem;
    }
};

// 35보다 작은 값들의 합

let less35 = function(elem, idx, ary) {
    if(elem < 35){
        result += elem;
    }
};


numAry.forEach(evenSum);
console.log("짝수값은: ", result);

numAry.forEach(oddSum);
console.log("홀수번째의 값은: ", result);

numAry.forEach(less35);
console.log("35보다 작은 값은: ", result);

const dupAry = [10, 27, 32, 55, 27, 10];
const ary = [];

// 중복은 제거된.
dupAry.forEach(function(elem){
    if(ary.indexOf(elem) == -1){
        ary.push(elem);
    }
})
console.log(ary);
 