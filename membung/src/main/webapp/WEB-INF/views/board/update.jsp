<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<table class="table">
<tbody>
	<tr>
		<th>번호</th>
		<td><input name="no" value="${update.no }" readonly="readonly" class="form-control"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input name="title" value="${update.title }" class="form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><input name="content" value="${update.content }" class="form-control"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input name="writer" value="${update.writer }" readonly="readonly" class="form-control"></td>
	</tr>
</tbody>
<tfoot>
	<tr>
		<td><button class="btn btn-default">수정</button>
		<button class="btn btn-default" type="reset">다시쓰기</button>
		<button class="btn btn-default" type="button" onclick="history.back()">되돌아가기</button>
		</td>
	</tr>
</tfoot>
</table>
</form>
</body>
</html>