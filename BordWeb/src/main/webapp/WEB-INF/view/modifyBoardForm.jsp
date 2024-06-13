<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../public/header.jsp" />

<form action="modifyBoard.do" method="post">
	<input type="hidden" name="bno" value="${board.boardNo}">
	<table class="table">
		<tr>
			<th width="100">글번호</th>
			<td width="500">${board.boardNo}</td>
			<th width="100">조회수</th>
			<td>${board.clickCnt}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><textarea cols="50" rows="1" name="title">${board.title}</textarea></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea cols="80" rows="3" name="content">${board.content}</textarea></td>
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
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-danger" value="수정"></td>
		</tr>
	</table>
</form>



<jsp:include page="../public/footer.jsp" />