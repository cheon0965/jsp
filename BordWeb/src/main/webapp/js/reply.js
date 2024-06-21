/**
 *  reply.js
 */

// 댓글목록 출력하기
let page = 1;
svc.replyList({bno, page}, replyListFnc);

// 댓글등록 이벤트
document.getElementById("addReply").addEventListener("click", addReplyFnc);

// 페이징 a 태그를 클릭하면 목록보여주기.
document.querySelectorAll("div.pagination > a").forEach(item =>{
    
    item.addEventListener("click", function(e){
        e.preventDefault();   
        page = item.innerHTML;
        svc.replyList({bno, page}, replyListFnc); 
    });
    
});

// 댓글건수를 활용해서 패이징계산하고 목록출력.

function makePagingFnc(){
    svc.replyTotalCnt(bno,createPagingList)
}
let pagination = document.querySelector("div.pagination");
function createPagingList(){
    let totalCnt = this.responseText;
    let startPage, endPage;
    let prev, next;
    let realEnd = Math.ceil(totalCnt / 5);

    endPage = Math.ceil(page / 5) * 5;
    startPage = endPage - 4;
    endPage = endPage > realEnd ? realEnd : endPage;

    prev = startPage > 1;
    next = endPage < realEnd;

    // startPage, endPage ,prev, new => a태그 생성.
    pagination.innerHTML = "";
    if(prev){
        let aTag = document.createElement("a");
        aTag.setAttribute("deta-page", startPage -1);
        aTag.setAttribute("href", "#");
        aTag.innerHTML = "&laquo;";
        pagination.appendChild(aTag);
    }

    for(let p = startPage; p <= endPage; p++){
        let aTag = document.createElement("a");
        aTag.setAttribute("deta-page", p);
        aTag.setAttribute("href", "#");
        aTag.innerHTML = p;

        if(page == p){
            aTag.className = "active";
        }
        pagination.appendChild(aTag);
    }

    if(next){
        let aTag = document.createElement("a");
        aTag.setAttribute("deta-page", endPage + 1);
        aTag.setAttribute("href", "#");
        aTag.innerHTML = "&raquo;";
        pagination.appendChild(aTag);
    }

    document.querySelectorAll("div.pagination > a").forEach(item =>{
    
        item.addEventListener("click", function(e){
            e.preventDefault();        
            page = item.getAttribute("deta-page");
            svc.replyList({bno, page}, replyListFnc);        
        });
        
    });

}

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
        // let li = cloneRow(result.retVal);
        // document.querySelector("div.content>ul").appendChild(li);
        page = 1;
        svc.replyList({bno, page}, replyListFnc);

        document.getElementById("reply").value = "";        
    }else{
        alert("tlfvo=>" + result.retVal);
    }
    
}


// replyLis의 매개값으로 사용할 함수.
function replyListFnc(){
    // 5개댓글을 지워주고 새롭개 목록출력
    document.querySelectorAll("div.content > ul > li").forEach((item,inx) => {
        if(inx >2 ){
            item.remove();
        }
    });
    let data = JSON.parse(this.responseText);
    data.forEach(reply =>{
        document.querySelector("div.content>ul").appendChild(cloneRow(reply));
    })
    makePagingFnc();
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
            // li.remove();
            svc.replyList({bno, page}, replyListFnc);
        }else{
            alert("Error=>" + result.returMsg);
        }
    }
    
}