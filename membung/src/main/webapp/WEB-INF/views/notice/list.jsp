<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(function(){
	$("tbody>tr").on("click", function(){
		var no = $(this).find("td:first").text();
		location = "/notice/view.do?no="+no+"&isView=true";
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
<table class="table">
	<thead>
		<tr>
			<td>공지번호</td>
			<td>공지제목</td>
			<td>공지시작일</td>
			<td>공지종료일</td>
		</tr>
	</thead>
	<tbody>
	<c:if test="${!empty list}">
	<c:forEach items="${list }" var="list">
		<tr>
			<td>${list.no }</td>
			<td>${list.title }</td>
			<td><fmt:formatDate value="${list.startDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			<td><fmt:formatDate value="${list.endDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
		</tr>
	</c:forEach>
	</c:if>
<!-- null이 아니라 list적어야 데이터가 나타는데 null 적어서 데이터가 나타지않음 -->

</tbody>
	<tfoot>
	<c:if test="${empty list}">
	<tr>
		<th><strong>자료가 없습니다.</strong></th>
	</tr>
</c:if>
	<c:if test="${!empty list }">
<tr>
<!-- 페이징 처리할 곳 -->
	<td colspan="5">
		<ul class="pagination">
		<!-- 이전 페이지 그룹으로 이동하는 링크 : 시작페이지가 1이면 안나온다. -->
			<c:if test="${page.startPage > 1 }">
				<li>
					<a href="list.do?page=${page.startPage - 1 }&key=${param.key}&word=${param.word}">&lt;&lt;</a>
				</li>
			</c:if>
			<!-- 페이지 링크가 나오는 부분 -->
			<c:forEach begin="${page.startPage }" end="${page.endPage }" var="cnt">
				<li <c:if test="${cnt == page.page }"> class="active"</c:if>>
				<a href="list.do?page=${cnt }&key=${param.key}&word=${param.word}">${cnt }</a>
				</li>
			</c:forEach>
			<!-- 다음 페이지 그룹 링크 : 마지막 페이지까지 왔으면 안나온다. -->
			<c:if test="${page.totalPage > page.endPage }">
				<li>
					<a href="list.do?page=${page.endPage + 1 }&key=${param.key}&word=${param.word}">&gt;&gt;</a>
				</li>
			</c:if>
		</ul>
	</td>
</tr>
</c:if>
<c:if test="${login.grade == 9 }">
		<tr>
			<td colspan="4">
				<a href="write.do">글쓰기</a>
			</td>
		</tr>
</c:if>
	</tfoot>
</table>
	<form>
		<select name="key">
			<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
			<option value="c" ${(param.key == "c")?"selected='selected'":"" }>내용</option>
			<option value="all" ${(param.key == "all")?"selected='selected'":"" }>모두</option>
		</select>
		
		<input name="word" value="${param.word }">
		<button> 검색</button>
<c:if test="${login.grade == 9 }">
		<div>
			<a href="list.do?period=per" class="btn btn-default">현재공지</a>
			<a href="list.do?period=old" class="btn btn-default">지난공지</a>
			<a href="list.do?period=res" class="btn btn-default">예약공지</a>
			<a href="list.do?period=all" class="btn btn-default">전체공지</a>
		</div>
</c:if>
	</form>
</body>
</html>