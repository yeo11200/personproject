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
<div>
	<input readonly="readonly" id=" no" name="no" value="${ReplyUpdate.no }" class="form-control" hidden="hidden">
</div>
<div>
	<lable>댓글번호</lable>
	<input readonly="readonly" id="rno" name="rno" value="${ReplyUpdate.rno }" class="form-control">
</div>
<div>
	<lable>작성자</lable>
	<input readonly="readonly" id="writer" name="writer" value="${ReplyUpdate.writer }" class="form-control">
</div>
<div>
	<lable>내용</lable>
	<textarea rows="5" name="content" class="form-control">${ReplyUpdate.content }</textarea>
</div>
<div>
	<button class="btn btn-primary">수정</button>
</div>
</form>
</body>
</html>