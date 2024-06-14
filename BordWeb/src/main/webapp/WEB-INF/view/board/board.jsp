<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



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
		<td colspan="3"><textarea cols="80" rows="3"><c:out value="${board.content}" /></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><c:out value="${board.writer}" /></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate }" /></td>
		
	</tr>
	<tr>
	<c:choose>
		<c:when test="${!empty logId && logId == board.writer}">
			<td><a href="removeForm.do?bno=${board.boardNo}&page=${page}&searchCondition=${search.searchCondition}&keyword=${search.keyword}"><input
					type="button" class="btn btn-danger" value="삭제"></a></td>
			<td><a href="modifyForm.do?bno=${board.boardNo}&page=${page}&searchCondition=${search.searchCondition}&keyword=${search.keyword}"><input
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
<a href="boardList.do?page=${page }&searchCondition=${search.searchCondition}&keyword=${search.keyword}">목록으로 이동하기</a>

<script>
	document.querySelector('button.btn-warning').addEventListener('click',
			function(e) {
				// 삭제화면이동일 경우에는 removeForm.do
				// 수정화면이동일 경우에는 action="modifyForm.do";
				document.forms.myFrm.action = "modifyForm.do";
				document.forms.myFrm.submit();
			});
	// 삭제화면이동일 경우에는 removeForm.do
	// 수정화면이동일 경우에는 action="modifyForm.do";
	// document.forms.myFrm.action = "modifyForm.do";
	// document.forms.myFrm.submit();
</script>
