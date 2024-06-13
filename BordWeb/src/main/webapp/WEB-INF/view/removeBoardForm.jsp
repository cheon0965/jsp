<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../public/header.jsp" />

<form action="removeBoard.do?bno=${board.boardNo}" method="post">
	<table class="table">
		<tr>
			<th width="100">글번호</th>
			<td width="500">${board.boardNo}</td>
			<th width="100">조회수</th>
			<td>${board.clickCnt}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea cols="80" rows="3" name="dd">${board.content}</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>{board.creationDate}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-danger" value="삭제"></td>
		</tr>
	</table>
</form>

<jsp:include page="../public/footer.jsp" />