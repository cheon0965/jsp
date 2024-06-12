<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../public/header.jsp"%>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>


<form action="removeBoard.do">
	<table class="table">
		<tr>
			<th width="100">글번호</th>
			<td width="500"><%=board.getBoardNo()%></td>
			<th width="100">조회수</th>
			<td><%=board.getClickCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea cols="80" rows="3"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=board.getCreationDate()%></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-danger" values="삭제"></td>
		</tr>
	</table>
</form>

<%@include file="../public/footer.jsp"%>