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
	<label>제목</label>
	<input name="title" id="title" class="form-control">
	<label>내용</label>
	<textarea rows="15" cols="2" name="questContent" class="form-control"></textarea>
	<label>작성자</label>
	<input name="writer" value="${login.id }" class="form-control" readonly="readonly">
	<button class="btn btn-default">등록</button>
	<button class="btn btn-default" type="button" onclick="history.back()">돌아가기</button>
</form>
</body>
</html>