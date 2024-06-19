/**
 * dom1.js
 */

 //document.getElementById("fruit").style.display ="none";
 document.querySelector("table.table tr:nth-of-type(5)").setAttribute("align", "center");

 // 페이지 로딩시 회원3명 출력

 for(let member in myMembers){
    document.getElementById("memberList").appendChild(addRow(myMembers[member]));
 }


 // 추가버튼 클릭이벤트 등록.
 document.getElementById("addBtn").addEventListener("click", addmemberFnc);
 document.getElementById("modBtn").addEventListener("click", modmemberFnc);
 document.getElementById("delBtn").addEventListener("click", delmemberFnc);
 let checkAll = document.querySelector("thead input[type='checkbox']")
 checkAll.addEventListener("change", chackAllFnc);
 



 
// this => 1.이벤트(이벤트 대상) 2.함수(window) 3.객체(객체자신)

 function chackAllFnc(){
    document.querySelectorAll("#memberList  tr").forEach(tr => tr.children[5].children[0].checked = this.checked);
 }

 function delmemberFnc(){
    let targetTr = document.querySelectorAll("#memberList  tr");
    for(let tr of targetTr){
        if(tr.children[5].children[0].checked){
            tr.remove();
        }
       
    }
}

 function addmemberFnc(){
    const id = document.getElementById("mid").value;
    const name = document.getElementById("mname").value;
    const phone = document.getElementById("mphone").value;
    const point = document.getElementById("mpoint").value;

    if(!id || !name || !phone){
        alert("필수값을 입력해주세요")
        return;
    }

    document.getElementById("memberList").appendChild(addRow({id, name, phone, point}));
    
    
    document.getElementById("mid").value = "";
    document.getElementById("mname").value = "";
    document.getElementById("mphone").value = "";
    document.getElementById("mpoint").value = "";
 }

 function addRow(member = {id, name, phone, point}){
    // tr > td *4
    const tr = document.createElement("tr");
    tr.addEventListener("click", showDetailFnc);

    for(let prop in member){
        const td = document.createElement("td");
        td.innerHTML = member[prop];
        tr.appendChild(td);
    }
    // 삭제버튼
    let td = document.createElement("td");
    let btn = document.createElement("button");
    btn.innerText = "삭제";
    btn.setAttribute("class", "btn btn-primary")
    btn.addEventListener("click", function(e){
        this.parentElement.parentElement.remove();
        e.stopPropagation();
    });
    td.appendChild(btn);
    tr.appendChild(td);
 
    // 체크박스 생성.
    td = document.createElement("td");
    btn = document.createElement("input");
    btn.innerText = "선택";
    btn.setAttribute("type", "checkbox")
    btn.addEventListener("click", removeTrElement);
    td.appendChild(btn);
    tr.appendChild(td);
    return tr;
   
    
 }

// 이벤트 핸들러
 function removeTrElement(e){
    e.stopPropagation();
        
    let targetTr = document.querySelectorAll("#memberList  tr");
    let cnt1 = 0;
    for(let tr of targetTr){
        if(tr.children[5].children[0].checked){
            cnt1++
        }
    }
    if(cnt1 == targetTr.length){
        checkAll.checked = true;
    }else{
        checkAll.checked = false;
    }
}

 function showDetailFnc(){
    document.getElementById("mid").value = this.children[0].innerText;
    document.getElementById("mname").value = this.children[1].innerText;
    document.getElementById("mphone").value = this.children[2].innerText;
    document.getElementById("mpoint").value = this.children[3].innerText;
 }

 function modmemberFnc(){
    let modmember = document.querySelectorAll("#memberList  tr");
    // 입력화면의 회원아이디 값을 가지고와 수정함.

    const id = document.getElementById("mid").value;
    const name = document.getElementById("mname").value;
    const phone = document.getElementById("mphone").value;
    const point = document.getElementById("mpoint").value;

    if(!id || !name || !phone){
        alert("필수값을 입력해주세요")
        return;
    }

    for(let tr of modmember){
        if(tr.children[0].innerText == id){
            tr.children[1].innerHTML = name;
            tr.children[2].innerHTML = phone;
            tr.children[3].innerHTML = point;
        }
    }
    document.getElementById("mid").value = "";
    document.getElementById("mname").value = "";
    document.getElementById("mphone").value = "";
    document.getElementById("mpoint").value = "";
 }

 