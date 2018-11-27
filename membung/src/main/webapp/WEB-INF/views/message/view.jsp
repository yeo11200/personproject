<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>메시지 보기</title>
<script type="text/javascript">
$(function(){
	// 이벤트 처리
	$("#deleteBtn").on("click",function(){
// 		alert("delete");
		if(!confirm("정말 삭제하시겠습니까?"))
		    // a tag로 이도하는 것을 무시 시킨다.
		    return false;
	});
	
});
</script>
</head>
<body>
<h1>메시지 보기</h1>
<table class="table">
<tbody>
	<tr>
		<th>번호</th>
		<td>${dto.no }</td>
	</tr>
	<tr>
		<th>보낸 사람(아이디)</th>
		<td>${dto.senderName }(${dto.sender })</td>
	</tr>
	<tr>
		<th>받는 사람(아이디)</th>
		<td>${dto.accepterName }(${dto.accepter })</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><pre>${dto.content }</pre></td>
	</tr>
	<tr>
		<th>보낸 날짜</th>
		<td><fmt:formatDate value="${dto.sendDate }"
		  pattern="yyyy-MM-dd"/></td>
	</tr>
</tbody>
<tfoot>
	<tr>
<!-- 	위의 내용이 한중에 2칸을 사용하고 있기 때문에 2칸을 한 칸으로 합쳐야 한다. -> colspan -->
		<td colspan="2">
			<a href="delete.do?no=${dto.no }" class="btn btn-default"
			id="deleteBtn">삭제</a>
			<a href="list.do" class="btn btn-default">리스트</a>
		</td>
	</tr>
</tfoot>
</table>

</body>
</html>