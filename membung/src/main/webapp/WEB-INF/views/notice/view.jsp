<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	$(function(){
		$("#delete").on("click",function(){
			// comfirm은 비교하는 값으로써 if문과 같이 써줘야 효과가 있다.
			var a = confirm("정말로 삭제하겠습니까?");
			if(a){
				return true;
			}
			else{
				return false;
			}
		});
	});
</script>
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
		<td>${view.content }</td>
	</tr>
	<tr>
		<th>시작일</th>
		<td><fmt:formatDate value="${view.startDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	</tr>
	<tr>
		<th>종료일</th>
		<td><fmt:formatDate value="${view.endDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	</tr>
</tbody>
<tfoot>
<%-- <c:if test="${login.grade == 9 }"> --%>
	<tr>	
		<td colspan="5">
			<a href="update.do?no=${view.no }">수정</a>
			<a href="delete.do?no=${view.no }" id="delete">삭제</a>
		</td>
	</tr>
<%-- </c:if> --%>
</tfoot>
</table>
</body>
</html>