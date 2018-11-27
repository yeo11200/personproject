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
			<th>제목</th>
			<td><input name="title" required="required" class="form-control"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="5" cols="60" name="content" class="form-control"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input name="writer" readonly="readonly" value="${login.id }" class="form-control"></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3">
				<button class="btn btn-default">글등록</button>
				<button type="reset" class="btn btn-default">다시쓰기</button>
				<button type="button" class="btn btn-default" onclick="history.back()">뒤로가기</button>
			</td>
		</tr>
	</tfoot>
</table>
</form>
</body>
</html>