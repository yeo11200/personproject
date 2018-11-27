<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" id="repass">
<div class="container">
<div>
	<label>아이디</label>
	<input name="id" value="${login.id }">
</div>
<div>
	<label>비밀번호</label>
	<input name="pw" value="${login.pw }">
</div>
<div>
<label>바꿀비밀번호</label>
<input type="password" name="newPw" id="pw">


</div>
<div>
<label>비밀번호확인</label>
<input type="password" id="newpwchk">
</div>
<div>
	<button class="btn btn-info">변경하기</button>
</div>
</div>
</form>
<script type="text/javascript">
	$(function(){
		$("#repass").on("submit",function(){
			
		});
	});
</script>
</body>
</html>