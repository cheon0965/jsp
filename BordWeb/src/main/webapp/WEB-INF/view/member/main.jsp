<%@page import="java.util.List"%>
<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	

	<h3>main 페이지</h3>

	<p>
		학생번호: ${student.stdNo }
	</p>
	<p>
		학생이름: ${student.stdName }
	</p>

	<h3>학생목록</h3>
	<ul>
	<c:forEach var="vo" items="${studentList}">
 	 <li>학번: ${vo.stdNo } 이름: <a href="product.do?stdNo=${vo.stdNo }">${vo.stdName }</a> 연락처: ${vo.phone }</li>
	</c:forEach>
	</ul>
	
	
	
