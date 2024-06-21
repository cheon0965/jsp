<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
div.reply {
	margin: 0;
}

div.reply div {
	margin: auto;
}

div.reply ul {
	list-style-type: none;
	margin-top: 3px;
	padding: 0;
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
}
</style>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>


<table class="table">
	<tr>
		<th width="100">글번호</th>
		<td width="500"><c:out value="${board.boardNo}" /></td>
		<th width="100">조회수</th>
		<td><c:out value="${board.clickCnt}" /></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><c:out value="${board.title}" /></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea cols="80" rows="3"><c:out
					value="${board.content}" /></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><c:out value="${board.writer}" /></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
				value="${board.creationDate }" /></td>

	</tr>
	<tr>
		<c:choose>
			<c:when test="${!empty logId && logId == board.writer}">
				<td><a
					href="removeForm.do?bno=${board.boardNo}&page=${page}&searchCondition=${search.searchCondition}&keyword=${search.keyword}"><input
						type="button" class="btn btn-danger" value="삭제"></a></td>
				<td><a
					href="modifyForm.do?bno=${board.boardNo}&page=${page}&searchCondition=${search.searchCondition}&keyword=${search.keyword}"><input
						type="button" class="btn btn-danger" value="수정"></a></td>
			</c:when>
			<c:otherwise>
				<td><a><input type="button" class="btn btn-danger"
						value="삭제"></a></td>
				<td><a><input type="button" class="btn btn-warning"
						value="수정"></a></td>
			</c:otherwise>
		</c:choose>

	</tr>
</table>

<!-- 댓글관련 -->
<div class="container reply">

	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-3" id="addReply">등록</button>
	</div>

	<div class="content">
		<ul>
			<li><span class="col-sm-1">글번호</span> <span class="col-sm-4">글내용</span>
				<span class="col-sm-2">작성자</span> <span class="col-sm-3">작성일시</span><span
				class="col-sm-1">삭제</span></li>
			<li><hr></li>
			<li style="display: none;"><span class="col-sm-1">글번호</span> <span
				class="col-sm-4">글내용</span> <span class="col-sm-2">작성자</span> <span
				class="col-sm-3">작성일시</span><span class="col-sm-1"><button
						onclick="deleteRow(event)">삭제</button></span></li>
		</ul>
	</div>
</div>

<div class="footer">
	<div class="center">
		<div class="pagination">
			<a href="#" class="active">1</a> 
			<a href="#" >2</a> 
			<a href="#">3</a> 
			<a href="#">4</a>
		</div>
	</div>
</div>
<!-- 댓글관련 -->

<a
	href="boardList.do?page=${page }&searchCondition=${search.searchCondition}&keyword=${search.keyword}">목록으로
	이동하기</a>
<script>
	const bno = "${board.boardNo}";
	const replyer = "${logId}";

	//document.querySelector('button.btn-warning').addEventListener('click',
	//function(e) {
	// 삭제화면이동일 경우에는 removeForm.do
	// 수정화면이동일 경우에는 action="modifyForm.do";
	//document.forms.myFrm.action = "modifyForm.do";
	//document.forms.myFrm.submit();
	//});
	// 삭제화면이동일 경우에는 removeForm.do
	// 수정화면이동일 경우에는 action="modifyForm.do";
	// document.forms.myFrm.action = "modifyForm.do";
	// document.forms.myFrm.submit();
</script>

<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>
