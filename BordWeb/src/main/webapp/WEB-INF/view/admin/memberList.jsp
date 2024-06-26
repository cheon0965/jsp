<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- memberList/jsp -->

<h3>회원목록(관리자용)</h3>

<table class="table" style="border-collapse: collapse;">
	<tr>
		<th>회원아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이미지</th>
	</tr>

	<c:forEach var="member" items="${memberList }">
	<tr>		
		<td>${member.userId}</td>
		<td>${member.userName}</td>
		<td>${member.userPw}</td>
		<td><img width="75px"
			src=${empty member.img ?  '' : 'images/'.concat(member.img)} alt=${empty member.img ? '없음' : '사진'} onError="this.style.visibility='hidden'"></td>	
	</c:forEach>

</table>
</ul>