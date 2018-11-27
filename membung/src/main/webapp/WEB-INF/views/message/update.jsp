<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판 글수정</title>
</head>
<body>
<h1>게시판 글수정</h1>
<div>
	<form method="post">
	
		<table class="table">
		<tbody>
			<tr>
				<th>번호</th>
				<td><input name="no" value="${dto.no }" 
					 class="form-control"
					 readonly="readonly" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input name="title" value="${dto.title }"
					 required="required" pattern=".{4,100}"
					 maxlength="100" class="form-control" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="60" class="form-control"
					 name="content">${dto.content }</textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="writer" value="${dto.writer }" 
					  class="form-control"/></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
		<!-- 	위의 내용이 한중에 2칸을 사용하고 있기 때문에 2칸을 한 칸으로 합쳐야 한다. -> colspan -->
				<td colspan="2">
			<!-- 	button tag의 기본 type은 submit 이므로 생략 할 수 있다. -->
					<button type="submit">수정</button>
					<button type="reset">새로입력</button>
					<button type="button" onclick="history.back()">취소</button>
				</td>
			</tr>
		</tfoot>
		</table>
		
	</form>
</div>
</body>
</html>