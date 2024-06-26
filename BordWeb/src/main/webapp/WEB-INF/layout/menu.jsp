<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<div class="border-end bg-white" id="sidebar-wrapper">

	<c:choose>
		<c:when test="${logId == null }">
			<div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>

		</c:when>
		<c:otherwise>
			<div class="sidebar-heading border-bottom bg-light">Start Bootstrap(${logId})</div>

		</c:otherwise>
	</c:choose>

	<div class="list-group list-group-flush">
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="main.do">메인페이지</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="studentForm.do">학생정보등록화면</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="script.do">자바스크립트</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="ajax.do">Ajax연습</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="publicData.do">공공데이터포털</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="addMemberForm.do">회원가입</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="image.do">이미지</a>




		<c:choose>
			<c:when test="${logId == null }">
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
			</c:when>
			<c:otherwise>
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>

			</c:otherwise>
		</c:choose>


	</div>
</div>