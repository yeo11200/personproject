<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table">
	<tbody>
	<tr>
		<th>번호</th>
		<td>${view.no }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${view.title }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><pre>${view.content }</pre></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${view.writer }</td>
	</tr>
	<tr>
		<th>질문날</th>
		<td><fmt:formatDate value="${view.writeDate }" pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${view.hit }</td>
	</tr>
	</tbody>
	<tfoot>
		<tr>
			<td>
<%-- 				<c:if test="${login.grade eq 9 }"> --%>
				<a href="answerWrite.do?no=${view.no }">답글 쓰기</a>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${login.id eq view.writer }"> --%>
				<a href="questUpdate.do?no=${view.no }">질문수정</a>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${login.id eq view.writer }"> --%>
				<a href="delete.do?no=${view.no }">질문삭제</a>
<%-- 				</c:if> --%>
			</td>
		</tr>
	</tfoot>
</table>
</body>
</html>