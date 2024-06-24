<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!-- memberList/jsp -->

<h3>회원목록(관리자용)</h3>
<c:forEach var="member" items="${memberList }">
	<li> id: ${member.userId } ${!empty member.img ?  '<img width="200px" src="images/${member.img}" alt="">' : ''}</li>
</c:forEach>