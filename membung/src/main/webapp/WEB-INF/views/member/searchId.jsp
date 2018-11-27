<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(function(){
// 	$("#findid").on("click",function(){
// 		window.open("/find/findId.do", 'width=300','height=300');
// 		var email = $("#email").val();
// 		var tel = $("#tel").val();
// 		var name = $("#gender").val();
// 		var gender = $("#gender").val();
// 		var idlist = $("#idlist").val();
// 		var postDate = {'name':name, 'tel':tel, 'name':name, 'gender':gender, 'idlist':idlist};
		
// 		$.ajax({
// 			async : true,
// 			type : 'POST',
// 			url: '/member/serachId.do',
// 			data : postDate,
// 			contentType : "application/x-www.form-urlencoded; charset=UTF-8",
// 			dataType : "json",
			
// 			success:function(data){
// 				var id = data.idlist;
// 				alert(idlist);
// 				$("#idlist").append("<strong>"+"회원의 아이디는 :" + id + "입니다</strong>");
// 			}
// // 			},
// // 			error: function(XMLHttpRequeset, textStatus, errorThrown){
// // 				alert("정보를 다시 입력해주시기 바랍니다");
// // 			}
// 		});
});
</script>
<title>Insert title here</title>
</head>
<body>
<div class="continal">
<form method="post">
<div>
<label>이름</label>
<input name="name">
</div>
<div>
<label for="email">이메일</label>
<input type="text" name="email" id="email">
</div>
<div>
<label for="tel">전화번호</label>
<input type="text" name="tel" id="tel">
</div>
<div>
<label>성별</label>
<input type="radio" value="남자" name="gender" checked="checked">남자
<input type="radio" value="여자" name="gender">여자
</div>
<div>
<button id="findid">아이디 찾기</button>
</div>
</form>
</div>
</body>
</html>