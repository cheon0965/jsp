

// DOM 연습.
document.querySelector("ul#fruit > li").innerHTML = "사과";

// li 생성.
let li = document.createElement("li");
li.innerHTML = '<b>오렌지</b>';
document.querySelector('ul#fruit').appendChild(li);
document.querySelector('ul#fruit > li').remove();
document.querySelector('ul#fruit > li').style.backgroundColor = "yellow";

console.log(document.querySelectorAll('#fruit>li'));
let lists = document.querySelectorAll('#fruit>li');

for (let list of lists) {
	// 버튼생성.
	let btn = document.createElement('button');
	btn.innerText = "삭제";
	btn.setAttribute("class", "btn btn-primary");
	btn.addEventListener("click", function() {
		btn.parentElement.remove();
	});
	list.appendChild(btn);


}

