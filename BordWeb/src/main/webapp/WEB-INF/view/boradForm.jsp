<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../public/header.jsp"%>

<form action="addBodard.do">

	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" style="width: 50%" maxlength="20"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" style="width: 50%"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols = "80" rows = "3" style="width: 50%"></textarea></td>
			
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-danger" values="저장"></td>
		</tr>
	</table>

</form>


<%@include file="../public/footer.jsp"%>