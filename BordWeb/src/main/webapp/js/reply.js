/**
 *  reply.js
 */

// 댓글목록 출력하기
svc.replyList(bno, replyListFnc);

// 댓글등록 이벤트
document.getElementById("addReply").addEventListener("click", addReplyFnc);


// 등록 실행함수 bno 
function addReplyFnc(){
    if(!replyer){
        alert("로그인하세요!!");
        return;
    }
    let reply = document.getElementById("reply").value;
    if(!reply){
        alert("댓글을 입력하세요!!");
        return;
    }

    svc.addReply({replyer, reply, bno}, addReplyCallback);
}


function addReplyCallback(){
    let result = JSON.parse(this.responseText);
    if(result.retCode == "OK"){
        alert("등록성공!!");
        let li = cloneRow(result.retVal);
        document.querySelector("div.content>ul").appendChild(li);
        document.getElementById("reply").value = "";
    }else{
        alert("tlfvo=>" + result.retVal);
    }
        
}


// replyLis의 매개값으로 사용할 함수.
function replyListFnc(){
    let data = JSON.parse(this.responseText);
    data.forEach(reply =>{
        document.querySelector("div.content>ul").appendChild(cloneRow(reply));
    })
}

// 댓글정보 -> li 생성.
function cloneRow(reply = {}){
	let template = document.querySelector("div.content > ul > li:nth-of-type(3)").cloneNode(true);
	template.style.display = "block";
	template.querySelector("span:nth-of-type(1)").innerHTML = reply.replyNo;
	template.querySelector("span:nth-of-type(2)").innerHTML = reply.reply;
	template.querySelector("span:nth-of-type(3)").innerHTML = reply.replyer;
	template.querySelector("span:nth-of-type(4)").innerHTML = reply.replyDate;
	template.querySelector("span:nth-of-type(5) > button").setAttribute("deleteid",reply.replyNo);
	return template;
}

function deleteRow(e){
    let li = e.target.parentNode.parentNode;
    let rno = e.target.getAttribute("deleteid");
    
    svc.removeReply(rno, deletRepltFnc);

    function deletRepltFnc(){
        let result = JSON.parse(this.responseText);
        if(result.returnCod == "OK"){
            alert(result.returMsg);
            li.remove();
        }else{
            alert("Error=>" + result.returMsg);
        }
    }
    
}