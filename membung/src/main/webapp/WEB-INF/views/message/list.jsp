<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL : JSP Standard Tag Library -> java를 쉽게 태그로 만들어 놓은 것 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>메시지 리스트</title>

<style type="text/css">
	tbody>tr:hover {
		background: #eee;
		cursor: pointer;
	}
</style>

<script type="text/javascript">
// 페이지의 도큐멘드(HTML 태그)가 다 표시된 후에 처리가 된다.
$(function(){
	// 이벤트처리 -> 문서가 로딩이 되고 나서 이벤트가 발생이되면 처리하는 내용을 정의해서 호출
// 	$("tbody>tr").click(function(){});
	$("tbody>tr").on("click",function(){
		// 데이터 한줄을 클릭하면 -> 글보기로 이동한다. js:location
		// 글번호를 넘겨 줘야 하는데 글번호는 클릭의 tr(this)에서 첫번째 td안의 글자가 글번이다.
		// $(this) : 클릭한 tr이 this가 된다.
		// .find("td:first") : 그안에 첫번째 td를 find()를 이용해서 찾는다.
		// .text() : 찾은 td안에 글자가 글번호이다. 글번호에 해당되는 글자를 가져온다.
		var no = $(this).find("td:first").text();
		// 리스트에서 글보기로 갈때만 1증가 시키기 위한 처리
		// isView가 true면 view.do에서 조회수 1증가시킨다.
		location = "view.do?no="+no;
	});
	
	// 삭제 처리된 후 경고 메시지 
	// BoardController.delete()에서 처리가 완료된 후 RedirectAttributes에
	// addFlashAttribute()를 이용해서 "DELETED" 라고 담아 두면 한번 사용하고 없어진다.
    <c:if test="${msg == 'DELETED'}">
	    alert("메시지 삭제가 완료되었습니다.");
	</c:if>
	// 글쓰기 처리된 후 경고 메시지 
	// BoardController.write()에서 처리가 완료된 후 RedirectAttributes에
	// addFlashAttribute()를 이용해서 "WRITED" 라고 담아 두면 한번 사용하고 없어진다.
    <c:if test="${msg == 'WRITED'}">
	    alert("메시지가 전송되었습니다.");
	</c:if>
});
</script>

</head>
<body>
<h1>메시지 리스트</h1>
<div>
	<form>
		<div>
			<select name="key">
				<option value="t"
					${(param.key == "t")?"selected='selected'":"" }
				>제목</option>
				<option value="c"
					${(param.key == "c")?"selected='selected'":"" }
				>내용</option>
				<option value="w"
					${(param.key == "w")?"selected='selected'":"" }
				>작성자</option>
				<option value="tc"
					${(param.key == "tc")?"selected='selected'":"" }
				>제목/내용</option>
				<option value="tw"
					${(param.key == "tw")?"selected='selected'":"" }
				>제목/작성자</option>
				<option value="cw"
					${(param.key == "cw")?"selected='selected'":"" }
				>내용/작성자</option>
				<option value="all"
					${(param.key == "all")?"selected='selected'":"" }
				>모두</option>
			</select>
			<!-- request.getPrameter("word")-> param.word -->
			<input name="word" value="${param.word }"/>
			<button>검색</button>
		</div>
	</form>
</div>
<table class="table">
<thead>
	<tr>
		<th>번호</th>
		<th>보낸사람(아이디)</th>
		<th>받은사람(아이디)</th>
		<th>보낸 날짜</th>
		<th>읽기 여부</th>
	</tr>
</thead>
<tbody>
<!-- list -> controller에서 request(model)에 담아 놓은 데이터 -->
<!-- 데이터가 있는 경우. 데이터를 출력한다. empty : null과  size=0을 동시에 비교 -->
<c:if test="${!empty list }">
	<!-- var="dto" list에 있는 데이터를 하나씩 꺼내서 page 객체에 dto라는 이름으로 담는다. -->
	<!-- 향상된 for-> for(MessageDTO dto : list){dto} -->
	<c:forEach items="${list }" var="dto" >
		<tr>
	<!-- 	dto.no -> BoardDTO 안에 property no를 찾는다. -> getNo() 호출한 것이다. -->
			<td>${dto.no }</td>
			<td>${dto.senderName }(${dto.sender })</td>
			<td>${dto.accepterName }(${dto.accepter })</td>
			<td><fmt:formatDate value="${dto.sendDate }" 
					pattern="yyyy-MM-dd"/></td>
			<td>${empty dto.acceptDate?"읽지않음":"읽음" }</td>
		</tr>
	</c:forEach>
</c:if>
</tbody>
<tfoot>
<!-- 데이터가 없는 경우 : 찾는 데이터가 존재하지 않습니다. -->
<c:if test="${empty list }">
	<tr>
		<td colspan="5">메시지가 존재하지 않습니다.</td>
	</tr>
</c:if>
<c:if test="${!empty list }">
	<!-- 페이지가 표시되는 부분 -->
	<tr>
	<td colspan="5">
			<ul class="pagination">
			<!-- 이전 페이지 그룹으로 이동하는 링크 : 시작 페이지가 1이면 안나온다. -->
			<c:if test="${page.startPage > 1 }">
				<li>
				 <a href="list.do?page=${page.startPage -1}&key=${param.key }&word=${param.word}" >&lt;&lt;</a>
				</li>
			</c:if>
			<!-- 페이지 링크가 나오는 부분 -->
			<c:forEach begin="${page.startPage }" end="${page.endPage }"
			 var="cnt">
		    	<li 
		    	<c:if test="${cnt == page.page }"> class="active" </c:if>>
		    	<a href="list.do?page=${cnt }&key=${param.key}&word=${param.word}">${cnt }</a></li>
			</c:forEach>
			
			<!-- 다음 페이지 그룹 링크 : 마지막 페이지까지 왔으면 안나온다. -->
		    <c:if test="${page.totalPage > page.endPage }">
		    	<li><a href="list.do?page=${page.endPage +1}&key=${param.key}&word=${param.word}" >&gt;&gt;</a>
		    	</li>
		    </c:if>
			    
		  </ul>
		</td>
	</tr>
	<!-- 페이지 표시하는 끝 -->
</c:if>
	
	<tr>
<!-- 	위에 칸이 5칸이므로 1칸으로 합쳐서 작업한다. : colspan -->
		<td colspan="5">
			<a href="write.do" class="btn btn-default">메시지쓰기</a>
		</td>
	</tr>
</tfoot>
</table>
</body>
</html>
