<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table">
<tr>
		<th>${view.id }</th>
</tr>
<tr>
		<th>${view.name }</th>
</tr>
<tr>
		<th>${view.grade }</th>
</tr>
<tr>
		<th>${view.tel }</th>
</tr>
<tr>
		<th><fmt:formatDate value="${view.writeDate}" pattern="yyyy-MM-dd"></fmt:formatDate></th>
</tr>
<tr>
		<th>${view.hobby }</th>
</tr>
<tr>
		<th>${view.gender }</th>
</tr>
<tr>
		<th>${view.email }</th>
		<!-- th인데 자바스크립트에 자꾸 td를 써서 에러가 발생함, 값도 안불러오는 불상사가 발생함 -->
</tr>
<tr>
		<th>${view.deleteMember }</th>
		<!-- th인데 자바스크립트에 자꾸 td를 써서 에러가 발생함, 값도 안불러오는 불상사가 발생함 -->
</tr>
<tr>
		<th><fmt:formatDate value="${view.deleteDate}" pattern="yyyy-MM-dd"></fmt:formatDate></th>
</tr>
<tfoot>
	<tr>	
	<!-- ?id=${view.id } -->
		<td colspan="5"><a href="updateDeleteMember.do?id=${view.id }" class="btn btn-default">탈퇴복수</a>
		<button type="button" class="btn btn-default" onclick="history.back()">리스트</button></td>
	</tr>
</tfoot>
</table>
</body>
</html>