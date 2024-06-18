/**
 * ary2.js
 */
 result = [23, 45, 22, 39, 10, 56].filter(function(item,idx,ary){
    if(item % 2 == 0){
        return true;
    }
 })

 console.log(result);
 
// 급여가 5000이 넘는 여자만 필터링
// filter(true) 인값을 배열로 반환해줌

let over5000 = [];
let over5000Sum = 0;

employees.filter(function(item,idx,ary){
    if(item.salary >= 5000 && item.gender == 'Female'){
        over5000.push(item);
    }
})
over5000 = employees.filter(item => item.salary >= 5000 && item.gender == 'Female');
over5000.forEach(item => over5000Sum += item.salary);

console.log(over5000);
console.log("조건을 만족하는 사람의 급여합: ", over5000Sum);


// map 활용 방법

employees.map(function(elem, idx, ary){
    const obj = {}    ;
    obj.name = elem.furst_name + '-' + elem.last_name;
    obj.no = elem.id;
    obj.salary = elem.salary;
    return obj;
}).forEach(console.log);

