/**
 *  public.js
 */

let url = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=X2q1HkLDiAlIKDai9i3olriVS4DdPw8PMNt5ih81HvMGllCKcLqppal5%2BnjT6BSieGcMvK0%2F1D1sDkRMYu9Sew%3D%3D"
const target = document.querySelector("#centerList"); // 하위목록

// 센터정보생성
document.getElementById("centerDB").addEventListener("click", createCenterInfo);

function createCenterInfo(){
	// 1.open API 호출.	
	// 2.컨트롤 호출 DB입력.
	fetch(url)
	.then(result => result.json())
	.then(result => {
		let centers = result.data; // [{},{},{}] => [{'id'},{'hong'}]
		return fetch("centerInfo.do", {
			method: "post", // 전달되는 값이 body영역에 저장
			headers: {"Content-Type": "application/json"}, // 키=값&키=값
			body: JSON.stringify(centers)
		})
		.then(result => result.json())
		.then(result => {
			if(result.txnCnt > 0){
				alert(result.txnCnt + "건 처리되었습니다.");
			}else{
				alert("실패");
			}
		})
		.catch();
	}).catch(err => console.log(err));
}

fetch(url)
	.then(result => result.json())
	.then(result => {
        makeRowSearchList(result.data); 
		result.data.forEach(center => {
			target.appendChild(makeRow(center));                       
		});
	})

// 검색기능
document.getElementById("searchBtn").addEventListener("click", research);
function research() {
	fetch(url)
		.then(result => result.json())
		.then(result => {
			target.innerHTML = "";
			result.data.forEach(center => {
				if (center.address.includes(document.getElementById("search").value)) {
					target.appendChild(makeRow(center));
				}
			});
		})
}

// 시도검색

function makeRowSearchList(result) {
	const sido = [];
    result.forEach(ele => {
        if(sido.indexOf(ele.sido) == -1){
            sido.push(ele.sido);
        }        
    });
	sido.forEach(ele => {
		let option = document.createElement("option");
        option.innerHTML = ele;
		option.value = ele;
        document.getElementById("searchList").appendChild(option);
	})
}

document.getElementById("searchList").addEventListener("change", searchList);
function searchList() {
	fetch(url)
		.then(result => result.json())
		.then(result => {
			target.innerHTML = "";
			result.data.forEach(center => {
				if (center.sido.includes(document.getElementById("searchList").value)) {
					target.appendChild(makeRow(center));
				}
			});
		})
}


// 
function makeRow(center) {
	const fields = ["id", "centerName", "phoneNumber", "address"];
	let tr = document.createElement("tr");
	tr.addEventListener("click",function(){
		window.open(`map.do?x=${center.lat}&y=${center.lng}&name=${center.centerName}`);
	});
	fields.forEach(ele => {
		let td = document.createElement("td");
		td.innerHTML = center[ele];
		tr.appendChild(td);
	})
	return tr;
}

