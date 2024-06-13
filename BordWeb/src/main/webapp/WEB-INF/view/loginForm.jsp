<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix = "myTag" %>

<jsp:include page="../public/header.jsp" />


<h3>로그인화면(loginForm.jsp)</h3>
<myTag:line/>
<form action="login.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw"></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>

<c:forEach var="i" begin="1" end="10" step="2">
<p>${i }</p>
</c:forEach>

<jsp:include page="../public/footer.jsp" />