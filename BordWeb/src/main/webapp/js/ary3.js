/**
 * ary3.js
 */

// reduce
sum = [10, 20, 30, 40, 50].reduce(function (acc, elem, idx, ary) {
    return acc + elem;
}, 0);

console.log("결과: ", sum);

let sum25 = [10, 20, 30, 40, 50].reduce(function (acc, elem, idx, ary) {
    if (elem > 25) {
        acc.push(elem);
    }
    return acc;
}, []);

console.log("결과: ", sum25);


let max = [10, 20, 30, 40, 50].reduce(function (acc, elem, idx, ary) {
    if (elem > acc) {
        return elem;
    }else{
        return acc;
    }
}, Number.MIN_VALUE);

console.log("최대값: ", max);

let min = [10, 20, 30, 40, 50].reduce(function (acc, elem, idx, ary) {
    if (elem < acc) {
        return elem;
    }else{
        return acc;
    }
}, Number.MAX_VALUE);

console.log("최소값: ", min);


days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Set'].reduce(function(acc,elem){
    let li = document.createElement('li');
    li.innerHTML = elem;
    acc.appendChild(li);
    return acc;
}, document.getElementById('fruit'))