<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(function(){
		$("tbody>tr").on("click", function(){
			// this -> tbody>tr
			var no = $(this).find("td:first").text();
			location = "/board/view.do?no="+no+"&isView=true";
		});
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table class="table table-hover">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="list">
	<tr>
	<td>${list.no }</td>
	<td>${list.title }</td>
	<td>${list.writer }</td>
	<td><fmt:formatDate value="${list.writeDate }" pattern="yyyy-MM-dd h:mm:s"></fmt:formatDate></td>
	<td>${list.hit }</td>
	</tr>
</c:forEach>
</tbody>
<tfoot>
<!-- empty 비어있는 -->
<c:if test="${empty list }">
<tr><th>자료가 없습니다.</th></tr>
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
<tr>
<td colspan="5">
<a href="write.do" class="btn btn-info">글쓰기</a></td>
</tr>
</tfoot>
</table>
<div>
	<form>
		<select name="key">
			<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
			<option value="c" ${(param.key == "c")?"selected='selected'":"" }>내용</option>
			<option value="all" ${(param.key == "all")?"selected='selected'":"" }>모두</option>
		</select>
		
		<input name="word" value="${param.word }">
		<button> 검색</button>
	</form>
</div>
</body>
</html>