<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
			<div class="container">
<form method="post" id="pwchk">
<div>
<label>아이디</label>
<input name="id" id="id">
</div>
<div>
<label>전화번호</label>
<input type="text" name="tel" id="tel">
</div>
<div>
<label>이메일</label>
<input type="text" name="email" id="email">
</div>
<div>
	<button>변경하기</button>
</div>
</form>
</div>
<script type="text/javascript">
	$(function(){
		$("#pwchk").on("submit", function(){
		});
});
</script>
</body>
</html>