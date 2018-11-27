<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	$(function(){
		$("tbody>tr").on("click",function(){
			// 데이터 한줄을 클릭하면 -> 글보기로 이동한다. js:location
			// 글번호를 넘겨 줘야 하는데 글번호는 클릭의 tr(this)에서 첫번째 td안의 글자가 글번이다.
			// $(this) : 클릭한 tr이 this가 된다.
			// .find("td:first") : 그안에 첫번째 td를 find()를 이용해서 찾는다.
			// .text() : 찾은 td안에 글자가 글번호이다. 글번호에 해당되는 글자를 가져온다.
			var id = $(this).find("th:first").text();
			// 리스트에서 글보기로 갈때만 1증가 시키기 위한 처리
			// isView가 true면 view.do에서 조회수 1증가시킨다.
			location = "view.do?id="+id;
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<table class="table">
<thead>
	<tr>	
		<th>아이디</th>
		<th>이름</th>
		<th>등급</th>
		<th>전화번호</th>
		<th>가입날짜</th>
		<th>취미</th>
		<th>성별</th>
		<th>이메일</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="list">
<tr>
		<th>${list.id }</th>
		<th>${list.name }</th>
		<th>${list.grade }</th>
		<th>${list.tel }</th>
		<th><fmt:formatDate value="${list.writeDate}" pattern="yyyy-MM-dd"></fmt:formatDate></th>
		<th>${list.hobby }</th>
		<th>${list.gender }</th>
		<th>${list.email }</th>
		<!-- th인데 자바스크립트에 자꾸 td를 써서 에러가 발생함, 값도 안불러오는 불상사가 발생함 -->
</tr>
</c:forEach>
<c:if test="${empty list }">
	<tr>
		<td><h2>찾는 값이 없습니다.</h2></td>
	</tr>
</c:if>
</tbody>
<tfoot>
	<tr>
		<td colspan="5">
		<button type="button" onclick="history.back()">페이지</button></td>
	</tr>
</tfoot>
</table>
</body>
</html>