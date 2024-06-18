/**
 * obj1.js
 */

document.getElementById("dom").remove();


 let obj2 = {
	data: '',
	fields: ['id','first_name','email', 'salary'],
	showList: function(ary = []){
		ary.forEach((emp,idx) => {
			if(idx <3){
				document.querySelector("#list").appendChild(this.makeRow(emp));
			}
		});
	},
	makeRow(emp = {id, first_name, email, salary}){
		let tr = document.createElement('tr');
		this.fields.forEach(field => {
			let td = document.createElement('td');
			td.innerHTML = emp[field];
			tr.appendChild(td);
		});
		return tr;
	}
 }
document.getElementById("addBtn2").addEventListener("click", function(e){
	let id = document.getElementById("pNum").value;
	let first_name = document.getElementById("pName").value;
	let email = document.getElementById("pPhone").value;
	let salary = document.getElementById("pSalary").value;
	let field = {id , first_name, email, salary}; // 키값고 변수값이 같아서 생락가능.
	document.querySelector("#list").appendChild(obj2.makeRow(field));

	e.stopPropagation();

	document.getElementById("pNum").value = '';
	document.getElementById("pName").value = '';
	document.getElementById("pPhone").value = '';
	document.getElementById("pSalary").value = '';
});


 
 obj2.showList(employees);


 const person = {
	name: "홍길동",
	age: 20
 }

 person.height = 167.8;
 person.showInfo = function(){
	return person.name + '-' + person.age + '-' + person.height;
 }
 let prop = 'age';
 console.log(person.prop);  // 이렇게는 찾을수 없음
 console.log(person[prop]); // 객체 값으로도 찾을수 있음
 console.log(person.showInfo());

 const today = new Date();
 today.getFullYear();
 
 
 // 2024-06-19  기존에 있는 메소드객체에 메소드 추가 가능
 Date.prototype.format = function(){
	 let yy = this.getFullYear();
	 let mon = this.getMonth() + 1;
	 let dd =  this.getDate();
	 
	 return yy + '-' + mon + "-" + dd;
	}	

 console.log(today.format());