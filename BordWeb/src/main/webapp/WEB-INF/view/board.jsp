<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../public/header.jsp"%>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
String nowpage = (String) request.getAttribute("page");
%>

<p><%=board%></p>
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
</table>
<a href="boardList.do?page=<%=nowpage%>">목록으로 이동하기</a>
<a href="removeForm.do?bno=<%=board.getBoardNo()%>">삭제</a>

<%@include file="../public/footer.jsp"%>