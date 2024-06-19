/**
 *  ajax3.js
 */

// 목록 가지고오기
 const xhtp = new XMLHttpRequest();
xhtp.open("get", "mambersAjax.do");
xhtp.send();
xhtp.onload = function(){
    let data = JSON.parse(xhtp.responseText);
    data.forEach(user => {
        document.getElementById("List").appendChild(makeRow(user));
    });
}

let fields = ['userId', 'userName', 'userPw', 'responsibility'];
function makeRow(obj = {}){
    let tr = document.createElement('tr');
    tr.addEventListener("dblclick", function(e){
        document.getElementById("myModal").style.display = "block";
        // 선택된 사용자 이름, 비번을 모달에 출력.
        document.getElementById("modify_name").value = this.children[1].innerHTML;
        document.getElementById("modify_pass").value = this.children[2].innerHTML;
        document.getElementById("modify_id").value = this.children[0].innerHTML;        
    });

    fields.forEach(field => {
        let td = document.createElement('td');
        td.innerHTML = obj[field];
        tr.appendChild(td);
    });
    let td = document.createElement('td');
    let btn = document.createElement('button');
    
    btn.innerHTML = "삭제";
    btn.className = "btn btn-primary";
    btn.addEventListener("click",function(){
        let checkId =  obj['userId'];
        const checkAjax = new XMLHttpRequest();
        checkAjax.open("get", `deleteAjax.do?id=${checkId}` );
        checkAjax.send();
        checkAjax.onload = () => {
        let result = JSON.parse(checkAjax.responseText);
        if(result.returnCod == "success"){
            alert("삭제완료.");            
            tr.remove();
        }else{
            alert("삭제실패.");
        }
    }
    });
    td.appendChild(btn);
    tr.appendChild(td);

    return tr;
}
// 수정이벤트
document.getElementById("modBtn").addEventListener("click",function(){
    let id = document.getElementById("modify_id").value;
    let name = document.getElementById("modify_name").value;
    let pass = document.getElementById("modify_pass").value;

    // Ajax 생성.
    // 정상적으로 정보가 업데이트 되면 화면 수정.
    // 수정이 안됬으면 화면수정X.
    const upAjax = new XMLHttpRequest();
    let url = `updateAjax.do?id=${id}&pass=${pass}&name=${name}}`;
    upAjax.open("get", url);
    upAjax.send();
    upAjax.onload = function(){
        let result = JSON.parse(upAjax.responseText);
        if(result.returnCod == "success"){
            document.querySelectorAll("#List > tr").forEach(e => {
                if (e.children[0].textContent == id){
                    e.children[1].textContent = name;
                    e.children[2].textContent = pass;
                }
            });
            // 모달창 닫기
            document.getElementById("myModal").style.display = "none";            
        }else{
            alert("실패");
        }
    }



    
});


// 등록이벤트
document.getElementById("addBtn").addEventListener("click",function(){
    let id = document.getElementById("uid").value;
    let pw = document.getElementById("upw").value;
    let name = document.getElementById("uname").value;
    let duty = document.getElementById("duty").value;

    const addAjax = new XMLHttpRequest();
    let url = `addAjax.do?id=${id}&pw=${pw}&name=${name}&duty=${duty}`;
    addAjax.open("get", url);
    addAjax.send();
    addAjax.onload = function(){
        let result = JSON.parse(addAjax.responseText);
        if(result.retCod == "OK"){
            let newMem = {userId: id, userName: name, userPw: pw, responsibility: duty};
            alert(result.retMsg);
            document.getElementById("List").appendChild(makeRow(newMem));

            document.getElementById("uid").value = ""; 
            document.getElementById("upw").value = "";
            document.getElementById("uname").value = "";
            document.getElementById("duty").value = "";
        }else{
            alert("실패");
        }
    }
});

// id 체크 이벤트
document.getElementById("uid").addEventListener("change", function(){
    let checkId =  this.value;
    const checkAjax = new XMLHttpRequest();
    checkAjax.open("get", `checkIdAjax.do?id=${checkId}` );
    checkAjax.send();
    checkAjax.onload = function(){
        let result = JSON.parse(checkAjax.responseText);
        if(result.returnCod == "Exist"){
            alert("이미 존재하는 아이디 입니다.");
            document.querySelector("#addBtn").disabled = true;
        }else{
            alert("등록가능한 아이디 입니다.");
            document.querySelector("#addBtn").disabled = false;
        }
    }
});


document.querySelectorAll("#List > tr").forEach(function(e){
    e.addEventListener("click", function(){
        document.getElementById("uid").value = e.children[0].textContent; 
        document.getElementById("upw").value = e.children[1].textContent;
        document.getElementById("uname").value = e.children[2].textContent;
        document.getElementById("duty").value = e.children[3].textContent;
    })
});


