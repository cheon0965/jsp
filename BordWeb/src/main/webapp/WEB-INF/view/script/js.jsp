<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- script/js.jsp -->

<div id="dom">

	<h3>자바스크립트 연습.</h3>

	<ul id="fruit">
		<li>apple</li>
		<li>banana</li>
	</ul>

	<table class="table">
		<tr>
			<th>회원아이디</th>
			<td><input type="text" id="mid"></td>
		</tr>
		<tr>
			<th>회원이름</th>
			<td><input type="text" id="mname"></td>
		</tr>
		<tr>
			<th>회원연락처</th>
			<td><input type="text" id="mphone"></td>
		</tr>
		<tr>
			<th>회원점수</th>
			<td><input type="text" id="mpoint"></td>
		</tr>
		<tr>
			<td colspan="2"><button id="addBtn">추가</button>
				<button id="modBtn">수정</button>
				<button id="delBtn">선택삭제</button></td>
		</tr>
	</table>
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>연락처</th>
				<th>포인트</th>
				<th>삭제</th>
				<th><input type="checkbox"></th>
			</tr>
		</thead>
		<tbody id="memberList"></tbody>
	</table>

	<select id="selectMonth">
		<option value="5">5월</option>
		<option value="6" selected>6월</option>
		<option value="7">7월</option>
	</select>

	<div id="show"></div>
</div>



<table class="table">
	<tr>
		<th>사번</th>
		<td><input type="text" id="pNum"></td>
	</tr>
	<tr>
		<th>사원명</th>
		<td><input type="text" id="pName"></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" id="pPhone"></td>
	</tr>
	<tr>
		<th>급여</th>
		<td><input type="text" id="pSalary"></td>
	</tr>
	<tr>
		<td colspan="2"><button id="addBtn2">추가</button>
			<button id="modBtn2">수정</button>
			<button id="delBtn2">선택삭제</button></td>
	</tr>
</table>

<table class="table">
	<thead>
		<tr>
			<th>사번</th>
			<th>이름(Firstname)</th>
			<th>이메일</th>
			<th>급여</th>
		</tr>
	</thead>
	<tbody id="list">

	</tbody>
</table>


<script src="js/data.js"></script>
<script src="js/dom1.js"></script>
<script src="js/func1.js"></script>
<script src="js/calendar.js"></script>
<script src="js/ary1.js"></script>
<script src="js/ary2.js"></script>
<script src="js/ary3.js"></script>
<script src="js/obj1.js"></script>