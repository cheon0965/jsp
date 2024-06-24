<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- publicData.jsp -->
<h3>공공데이터 연습</h3>
주소검색:
<input type="text" id="search" placeholder="ex)동구">
<button id="searchBtn">검색</button>
시도검색:
<select id="searchList">
<option value="">선택</option>
</select>
<button id="centerDB">센터DB생성</button>
<p>sido 정보에서 중복된 값을 제거하여 아래 oprion 태그를 생성하고 검색하기</p>
<table class="table">
	<thead>
		<tr>
			<th>센터id</th>
			<th>센터명</th>
			<th>연락처</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody id="centerList"></tbody>
</table>

<script src="js/public.js"></script>
