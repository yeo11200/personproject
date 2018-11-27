<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form method="post" id="repass">
<div>
	<label>아이디</label>
	<input name="id" value="${dto.id }">
</div>
<div>
	<label>전화번호</label>
	<input name="tel" value="${dto.tel }">
</div>
<div>
	<label>이메일</label>
	<input name="email" value="${dto.email }">
</div>
<div>
<label>바꿀비밀번호</label>
<input type="password" name="pw" id="pw">


</div>
<div>
<label>비밀번호확인</label>
<input type="password" id="newpwchk">
</div>
<div>
	<button class="btn btn-defult">변경하기</button>
</div>
</form>
</div>
<script type="text/javascript">
	$(function(){
		$("#repass").on("submit",function(){
			
		});
	});
</script>
</body>
</html>