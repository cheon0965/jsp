<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- webapp/WEB-INF/view/product.jsp -->
	<h3>product페이지</h3>


	<table border="2">
		<tr>
			<td>학생번호</td><td>${student.stdNo}</td>
		</tr>
		<tr>
			<td>학생이름</td><td>${student.stdName}</td>
		</tr>
		<tr>
			<td>전화번호</td><td>${student.phone}</td>
		</tr>
		<tr>
			<td>학생이름</td><td>${student.bldType}</td>
		</tr>
	</table>
	
	<a href="main.do">메인 페이지로</a>
	
</body>
</html>