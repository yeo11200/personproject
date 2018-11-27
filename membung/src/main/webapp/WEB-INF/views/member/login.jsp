<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(function(){
	$("#login").on("click",function(){
		// 이벤트 처리가 되었는지 확인하는 alter
		// alert("이벤트 발생");
		// Ajax를 이용해서 서버로 갔다오도록 만드는데 전달할 데이터(아이디입력한 데이터)
		//$("#id").val($("id").val().trim());
		// #를 쓰지않아서 에러가 발생했다
		$("#id").val($("#id").val().trim());
		var id = $("#id").val();
		// alert(id);
		// 글자의 길이가 4자 이상일 때
		// 서버로 데이터를넘겨서 결과를 받아서 만들어진 div:checkResult에 데이터를 올려놓는다.
		// Ajax : load(), $.ajax(), $.getJSON() 등등
		$("#checkResult").load("/chkId/checkLogin.do", function(status){
			if(status == "error"){
				location = "/member/login.do";
			}
		});
						// load에 해당하는 것이 Ajax
	});
});
</script>
<title>로그인 페이지</title>
</head>
<body>
<div class="container">
	<h1>로그인 페이지</h1>
		<form method="post">
		<div>
		<label>아이디</label>
		<input name="id" class="form-control">
		</div>
		<div>
		<label>비밀번호</label>
		<input name="pw" type="password" class="form-control">
		</div>
		<div>
		<button id="login" class="btn btn-primary">로그인</button>
		</div>
		<!-- grade 테이블에 데이터가 없어서 로그인이 되질 않았다. -->
		</form>
		</div>
			<div class="container">
			<!-- 회원가입/ 아이디찾기/ 비밀번호 찾기 -->
			<a href="join.do" class="btn btn-info">회원가입</a>
			<a href="searchId.do" class="btn btn-info">아이디찾기</a>
			<a href="middleSerchPw.do" class="btn btn-info">비밀번호찾기</a>
			<!-- form태그안에 들어가있으면 method에 영향을 받아서 로그인 처리버튼으로 됨 -->
		</div>
</body>
</html>