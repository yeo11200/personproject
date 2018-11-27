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
  <style type="text/css">
  .blue{
  color: blue;
  }
  .red{
  color: red;
  }
  </style>
  <script type="text/javascript">
// Ajax를 처리하고 생각한다면 1.이벤트가 우선 그후에 2.Ajax처리
	$(function(){
		$("#id").on("keyup",function(){
			// 이벤트 처리가 되었는지 확인하는 alter
			// alert("이벤트 발생");
			// Ajax를 이용해서 서버로 갔다오도록 만드는데 전달할 데이터(아이디입력한 데이터)
			//$("#id").val($("id").val().trim());
			// #를 쓰지않아서 에러가 발생했다
			$("#id").val($("#id").val().trim());
			var id = $("#id").val();
			// alert(id);
			// 글자의 길이가 4자 이상일 때
			if(id.length>=4){
			// 서버로 데이터를넘겨서 결과를 받아서 만들어진 div:checkResult에 데이터를 올려놓는다.
			// Ajax : load(), $.ajax(), $.getJSON() 등등
			$("#checkResult").load("/chkId/checkId.do?id="+id);
							// load에 해당하는 것이 Ajax
			}
		});
		
		// 비밀번호와 비밀번호 확인을 입력하면 처리되는 이벤트
		$("#pw, #pwchk").on("keyup", function(){
			// alert("비밀번호 입력");
			var pw = $("#pw").val();
			// pw부분의 값을 var pw에 값을 저장한다.
			//alert(pw)
			var pwchk = $("#pwchk").val();
			// pw의 값이 4자 이하면 4자 이상 입력하세요 
			//alert(pwchk)
			// 밑에 비밀번호 확인에 id가 달라서 에러도 발생하지않고 undifind만 나옴
			if(pw.length < 4){
				$("#chkPw2").text("4자이상입력하세요").css("color","red");
				// 아이디           형식
			}
			// 4자 이상인 경우 비밀번화와 비밀번호 확인이 다르면 비밀번호, 비밀번호 확인이 같지 않습니다.
			else if(pw!=pwchk){
				$("#chkPw2").text("비밀번호가 같지않습니다.").css("color","red");
			}
			else{
				$("#chkPw2").text("사용가능한 비밀번호").css("color","blue");
			}
		});
		// 데이터를 전송할 때 정확한 데이터를 입력했는지 확인하는 프로그램 작성
		// 이벤트 submit이벤트 form태그의 이벤트
/* 		$('btn').on('click', e => {
  e.preventDefault();
  e.stop어쩌구 하는거 
}) */
		$("#joinForm").on("submit", function(){
			// alert("데이터 전송");
			// 데이터를 전송시키지 않는다. -> true나 아무것도 안적으면 넘어가는데 false는 안넘어간다.
			// 필수입력 사항 : 1.val().length == 0, 2. val() == ""
			// 아이디, 비밀번호, 이름
			if($("#id").val().length==0){ 
				// 경고창을 띄운다. -> 커서를 필수입력 항목에 위치 시킨다.
				alert("아이디는 필수 사항입니다");
				$("#id").focus();
				return false;
			}
			if($("#pw").val() ==""){
				alert("비밀번호는 필수 입력 사항입니다");
				$("#pw").focus();
				return false;
			}
			if($("#pwchk").val() ==""){
				alert("비밀번호는 필수 입력 사항입니다");
				$("#pwchk").focus();
				return false;
			}
			if($("#name").val() == ""){
				alert("이름은 필수 사항입니다");
				$("#name").focus();
				return false;
			}
			// 아이디 중복체크 여부확인
			// 사용가능한 아이디가 아니면 다른 아이디를 선택하세요
			if($("#checkResult").text() != "사용이 가능합니다."){
				alert("중복이 됩니다.");
				//$("#id").clean();
				$("#id").val("").foucs();
				return false;
			}
			// 비밀번호와 비밀번호 확인
			// 다르면 비밀번호와 비밀번호 확인이 같지 않습니다. -> 두개의 데이터를 지운다
			if($("#pw").val() != $("#pwchk").val()){
				alert("비밀번호가 서로 같아야합니다.");
				$("#pw").val("").foucs;
				$("#pwchk").val("");
				return false;
				//$("#join").attr("disabled","disabled");
			}
			/* 	if($("#pw").val() != $("pwchk").val()){
			alert("비밀번호 확인하세요");
			$("#pw").focus();
			return false;
			} */
			//return false;
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<!-- 아이디 : 아이디 중복체크(Ajax), 비밀번호, 비밀번호 확인(jQurey), 이름, 성별 -->
<div class="container">
<form method="post" id="joinForm">
<div>
<label>아이디</label>
<input name="id" id="id" class="form-control"/>
<!-- 위에 id를 입력할 때 마다 (1. 이벤트:keyup) 서버에 갔다와서 (2. Ajax) 결과를 아래의 div에 표시한다.(load()) -->
<div id="checkResult"></div>
</div>
<div>
<label>비밀번호</label>
<input name="pw" type="password" id="pw" class="form-control">
<span id="chkPw"></span>
</div>
<div>
<label>비밀번호확인</label>
<input name="pwChk" type="password" id="pwchk" class="form-control">
<span id="chkPw2"></span>
</div>
<div>
<label>이름</label>
<input name="name" id="name" class="form-control">
</div>
<div >
<label for="hobby">취미</label>
<label class="checkbox-inline"><input type="checkbox" id="hobby" name="hobby" value="게임">게임 </label>
<label class="checkbox-inline"><input type="checkbox" id="hobby" name="hobby" value="승마">승마 </label>
<label class="checkbox-inline"><input type="checkbox" id="hobby" name="hobby" value="코딩">코딩</label><br>
</div>
<div>
<label for="email">이메일</label>
<input type="text" name="email" id="email" class="form-control">
</div>
<div>
<label for="tel">전화번호</label>
<input type="text" name="tel" id="tel" class="form-control">
</div>
<div id="gender">
<label>성별</label>
<label class="radio-inline"><input type="radio" name="gender" value="남자" checked="checked"> 남자</label>
<label class="radio-inline"><input type="radio" name="gender" value="여자"> 여자</label>
</div>
<div>
<button id="join" class="btn btn-primary">가입</button>
<button type="reset" class="btn btn-default">다시쓰기</button>
<button type="button" onclick="history.back()" class="btn btn-default">돌아가기</button>
</div>
</form>
</div>
<!-- <script type="text/javascript">
// Ajax를 처리하고 생각한다면 1.이벤트가 우선 그후에 2.Ajax처리
	$(function(){
		$("#id").on("keyup",function(){
			// 이벤트 처리가 되었는지 확인하는 alter
			// alert("이벤트 발생");
			// Ajax를 이용해서 서버로 갔다오도록 만드는데 전달할 데이터(아이디입력한 데이터)
			$("#id").val($("id").val().trim());
			var id = $("#id").val();
			alert(id);
			// 글자의 길이가 4자 이상일 때
			if(id.length>=4){
			// 서버로 데이터를넘겨서 결과를 받아서 만들어진 div:checkResult에 데이터를 올려놓는다.
			$("#checkResult").load("checkId.do?=id"+id);
							// load에 해당하는 것이 Ajax
							// "checkId.id?id=" +id -> 로 했어야 에러가 발생하지않는데 내가 쓴대로 하면 에러가 발생한다.
			}
		});
	});
</script> -->
</body>
</html>