<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 글보기</title>
<style type="text/css">
	img{
		max-height: 100%;
		max-width: 100%;
	}
</style>
<script type="text/javascript">
$(function(){
	// view에서 f5키 방지를한다. 
// 	$(document).on("keydown",function(e){
// 		if(e.which === 116){
// 			if(typeof event == "object"){
// 				event.keyCode = 0;
// 			}
// 			return false;
// 		}else if(e.which === 82 && e.ctrlKey){
// 			return false;
// 		}
// 	});
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
		location = "/sell/ReplyUpdate.do?no="+no+"&rno="+rno;
	});
	
	$("#delete").on("click", function(){
		alert("cvli");
		// hidden으로 하면 데이터가 넘어가지 않는다.
		var no = $("#BoardNo").find("td:first").text();
		alert(no);
		var rno = $("#ReplyRno").find("td:first").text();
		alert(rno);
		location= "/sell/ReplyDelete.do?no="+no+"&rno="+rno;
	});
		$("#here").on("click", function(){
		location = "/member/login.do";
	});
	
	// 이벤트 처리
	$("#deleteBtn").on("click",function(){
// 		alert("delete");
		if(!confirm("정말 삭제하시겠습니까?"))
		    // a tag로 이도하는 것을 무시 시킨다.
		    return false;
	});
	
	// 수정 처리된 후 경고 메시지 
	// BoardController.update()에서 처리가 완료된 후 RedirectAttributes에
	// addFlashAttribute()를 이용해서 "UPDATED" 라고 담아 두면 한번 사용하고 없어진다.
    <c:if test="${msg == 'UPDATED'}">
	    alert("게시글 수정이 완료되었습니다.");
	</c:if>
});
</script>
</head>
<body>
<h1>게시판 글보기</h1>

<table class="table">
<tbody>
	<tr id="BoardNo"> 
		<th>번호</th>
		<td>${view.no }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${view.title }</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td><img src="/upload/image/${view.fileName } ">
<!-- 		<div> -->
<%-- 		${view.fileName } --%>
<!-- 		</div> -->
		</td>
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
		<th>작성일</th>
		<td><fmt:formatDate value="${view.writeDate }"
		  pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr>
		<th>조횟수</th>
		<td><fmt:formatNumber value="${view.hit }"
			pattern="#,##0" /> </td>
	</tr>
</tbody>
<tfoot>
<c:if test="${!empty ReplyList }">
	<tr >
		<th>댓글번호</th>
		<th>작성자</th>
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
<td colspan="5">
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
</tfoot>
</table>

<!-- 	위의 내용이 한중에 2칸을 사용하고 있기 때문에 2칸을 한 칸으로 합쳐야 한다. -> colspan -->
		<!--  본인이 올린 이미지와 글에서만 수정과 삭제가 가능하다. -->
		<c:if test="${login.id eq view.writer }">
			<a href="update.do?no=${view.no }" class="btn btn-default">수정</a>
			<a href="delete.do?no=${view.no }" class="btn btn-default" id="deleteBtn">삭제</a>
		</c:if>
			<a href="list.do" class="btn btn-default">리스트</a>
<form action="ReplyWrite.do" method="post"> 
<c:if test="${!empty login }">
<input type="hidden" name="no" value="${view.no }">
	<input type="text" name="writer" value="${login.id }" readonly="readonly" class="form-control">
<textarea name="content" cols="20" rows="3" class="form-control"></textarea>
<button class="btn btn-default">댓글 쓰기</button>
</c:if>
<c:if test="${empty login }">
<input type="text" name="writer" readonly="readonly" class="form-control" id="here">
<strong><textarea name="context" cols="20" rows="5" readonly="readonly" class="form-control" id="here">로그인후에 이용하세요</textarea></strong>
</c:if>
</form>
</body>
</html>