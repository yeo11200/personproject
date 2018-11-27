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
<!-- 관련글번호, 순서번호, 들여쓰기번호 안보이게 넘긴다. -->
<input type="hidden" name="refNo" value="${quest.refNo }">
<input type="hidden" name="ordNo" value="${quest.ordNo }">
<input type="hidden" name="levNo" value="${quest.levNo }">

<div class="form-group">
<label for = "no">번호</label>
<input type="text" class="form-control" id="no" value="${quest.no }" name="no" readonly="readonly">
</div>
<div class="form-group">
<label for = "title">제목</label>
<input type="text" class="form-control" 
id="title" value="[답변] ${quest.title }" name="title">
</div>

<div class="form-group">
<label for = "content">내용</label>
<textarea class="form-control" rows="5" name="content" id="content">
[질문내용] --------------
${quest.content }

[답변내용]

</textarea>
</div>
<div class="form-group">
<label for = "writer">작성자</label>
<input type="text" class="form-control" id="writer" name="writer" value="관리자">
</div>
<button type="submit" class="btn btn-defalut">답변 등록</button>
</form>
</body>
</html>