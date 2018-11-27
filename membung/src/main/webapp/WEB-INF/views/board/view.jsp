<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#update:hover{
		background: #ff0a00;
	}
	#delete:hover{
		background: #ff0a00;
	}
	#writer{
		width: 50px;
	}
</style>
<script type="text/javascript">
$(function(){
	$("#update").on("click", function(){
		alert("cvli");
		// hidden으로 하면 데이터가 넘어가지 않는다.
		var no = $("#BoardNo").find("td:first").text();
		alert(no);
		var rno = $("#ReplyRno").find("td:first").text();
		// hidden으로 하면 데이터가 넘어가지 않는다.
		//var no = $("#ReplyRno").find("td:second").text();
		//alert(no);
		alert(rno);
		location = "/board/ReplyUpdate.do?no="+no+"&rno="+rno;
	});
	
	$("#delete").on("click", function(){
		alert("cvli");
		// hidden으로 하면 데이터가 넘어가지 않는다.
		var no = $("#BoardNo").find("td:first").text();
		alert(no);
		var rno = $("#ReplyRno").find("td:first").text();
		alert(rno);
		location= "/board/ReplyDelete.do?no="+no+"&rno="+rno;
	});
	
	$("#here").on("click", function(){
		location = "/member/login.do";
	});
	
	$("#delete").on("click",function(){
		confirm("정말로 삭제하겠습니까?");
	});
	$("#boarddelete").on("click",function(){
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
<form action="ReplyWrite.do" method="post"> 
<table class="table table-hover">
<thead id="BoardNo">
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
		<th>작성자</th>
		<td>${view.writer }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><fmt:formatDate value="${view.writeDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${view.hit }</td>
	</tr>
</thead>
<tbody>
<c:if test="${!empty ReplyList }">
	<tr>
		<th id="rno">댓글번호</th>
		<th id="writer">작성자</th>
		<th>내용</th>
	</tr>
</c:if>
<c:forEach items="${ReplyList }" var="list">
	<tr id="ReplyRno">
		<td>${list.rno }</td>
		<td>${list.writer }(<fmt:formatDate value="${list.writeDate}" pattern="yyyy-MM-dd"></fmt:formatDate>)</td>
		<td>${list.content }</td>
		<c:if test="${login.id eq list.writer}">
		<td><button type="button" id="update" class="btn btn-info">댓글수정</button>
		<button type="button" id="delete" class="btn btn-info">댓글삭제</button></td>
		<!-- <a id="update">댓글수정</a>,<a id="delete">댓글삭제</a> -->
		</c:if>
	</tr>
</c:forEach>
<c:if test="${empty ReplyList }">
<tr>
<td>
 댓글이 없습니다.
</td>
</tr>
</c:if>
<c:if test="${!empty ReplyList }">
	<tr>
	<!-- 페이징 처리할 곳 -->
		<td colspan="5">
			<ul class="pagination">
			<!-- 이전 페이지 그룹으로 이동하는 링크 : 시작 페이지가 1이면 안나온다. -->
				<c:if test="${page.startPage > 1 }">
					<li>
						<a href="view.do?no=${view.no }&page=${page.startPage - 1}">&lt;&lt;</a>
					</li>	
				</c:if>
				<!-- 페이지 링크가 나오는 부분 -->
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="cnt">
					<li <c:if test="${cnt == page.page }"> class="active"</c:if>>
					<a href="view.do?no=${view.no }&page=${cnt}">${cnt }</a>
					</li>
				</c:forEach>
				<!-- 다음페이지 그룹링크 : 마지막 페이지까지 왔으면 안나온다 -->
				<c:if test="${page.totalPage > page.endPage }">
					<li>
						<a href="view.do?no=${view.no }&page=${page.endPage + 1}">&gt;&gt;</a>
					</li>				
				</c:if>
			</ul>
		</td>
	</tr>
</c:if>
<c:if test="${login.id eq view.writer }">
<tr>
	<td><a href="update.do?no=${view.no }" class="btn btn-default">글수정</a></td>
	<td><a href="delete.do?no=${view.no }" class="btn btn-default" id="boarddelete">글삭제</a></td>
</tr>
</c:if>
</tbody>
<tfoot>
<c:if test="${!empty login }">
<tr>
	<td><input type="hidden" name="no" value="${view.no }">
	<input type="text" name="writer" value="${login.id }" readonly="readonly" class="form-control"></td>
</tr>
<tr>
	<td><textarea name="content" cols="20" rows="5" class="form-control"></textarea></td>
</tr>
<tr>
	<td><button class="btn btn-default">댓글 쓰기</button></td>
</tr>
</c:if>
<c:if test="${empty login }">
<tr>
	<td><input type="text" name="writer" readonly="readonly" class="form-control" id="here"></td>
</tr>
<tr>
	<td><strong><textarea name="context" cols="20" rows="5" readonly="readonly" class="form-control" id="here">로그인후에 이용하세요</textarea></strong></td>
</tr>
</c:if>
</tfoot>
</table>
</form>
</body>
</html>