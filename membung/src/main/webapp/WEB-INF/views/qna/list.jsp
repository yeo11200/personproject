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
		$("tbody>tr").on("click",function(){
			var no = $(this).find("td:first").text();
			location = "/qna/view.do?no="+no+"&isView=true";
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<table class="table">
<thead>	
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성일</th>
		<th>작성자</th>
		<th>조회수</th>
	</tr>
</thead>
<tbody>
<c:if test="${!empty list }">
<c:forEach items="${list }" var="dto">
	<tr>
		<td>${dto.no }</td>
		<td><c:forEach begin="1" end="${dto.levNo *5 }">&nbsp;</c:forEach>
		<c:if test="${dto.levNo >=1 }">
		<span class="glyphicon glyphicon-arrow-right"></span> 
		</c:if>
		${dto.title }</td>
		<td>${dto.writer }</td>
		<td>${dto.writeDate }</td>
		<td>${dto.hit }</td>
	</tr>
</c:forEach>
</c:if>
</tbody>
<tfoot>
	<c:if test="${empty list }">
		<tr><td><strong>데이터가 아직 없습니다.</strong></td></tr>
	</c:if>
	<c:if test="${!empty list }">
		<tr>
			<td colspan="5">
			<ul class="pagination">
				<c:if test="${page.startPage > 1 }">
					<li>
						<a href="list.do?page=${page.startPage - 1 }&key=${param.key}&word=${param.word}">&lt;&lt;</a>
					</li>
				</c:if>
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="cnt">
					<li <c:if test="${cnt == page.page }">class="active"</c:if>>
						<a href="list.do?page=${cnt }&key=${param.key}&word=${param.word}">${cnt }</a>
					</li>
				</c:forEach>
				<c:if test="${page.totalPage > page.endPage }">
					<li>
						<a href="list.do?page=${page.endPage + 1 }&key=${param.key}&word=${param.word}">&gt;&gt;</a>
					</li>
				</c:if>
			</ul>
			</td>
		</tr>
	</c:if>
<%-- 	<c:if test="${!empty login }"> --%>
	<tr>
		<td colspan="5"><a href="questWrite.do" class="btn btn-info">글쓰기</a></td>
	</tr>
<%-- 	</c:if> --%>
</tfoot>
</table>
<form>
	<select name="key">
		<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
		<option value="qc" ${(param.key == "qc")?"selected='selected'":"" }>질문글</option>
		<option value="ac" ${(param.key == "ac")?"selected='selected'":"" }>답변글</option>
		<option value="all" ${(param.key == "all")?"selected='selected'":"" }>전체</option>
	</select>
	<input name="word"><button>검색</button>
</form>
</body>
</html>