/**
 *  replyService.js
 *  목록, 단건, 등록, 삭제
 */

const svc = {
	// 목록
	replyList(bno = 1, successCal){
		const xhtp = new XMLHttpRequest();
		xhtp.open("get", "replyListJson.do?bno=" + bno);
		xhtp.send();
		xhtp.onload = successCal;
	},
	//단건조회.
	getReply(){
		
	},
	// 등록
	addReply(rvo = {reply, replyer, bno}, successCal){
		const addAjax = new XMLHttpRequest();
		addAjax.open("post", `addReply.do` );
		addAjax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        addAjax.send("bno=" + rvo.bno + "&reply=" + rvo.reply + "&replyer=" + rvo.replyer);
        addAjax.onload = successCal;
	},
	// 삭제
	removeReply(rno = 1, successCal){
		const deleteAjax = new XMLHttpRequest();
		deleteAjax.open("get", `removeReply.do?rno=${rno}` );
        deleteAjax.send();
        deleteAjax.onload = successCal;
	}
}
 