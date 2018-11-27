<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>My page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <style>
body,ul,li,h1,h2,h3{margin: 0;padding: 0;}
.mypage *{box-sizing: border-box;-webkit-box-sizing: border-box;-moz-box-sizing: border-box;}
.mypage{width: 1000px;margin: 0 auto;}
.mypage ul{border:1px solid #ddd;text-align: center;}
.mypage ul:after{content: '';display: block;clear:both}
.mypage li{float: left;width: 33.333333333333%;list-style: none;border-left: 1px solid #ddd;}
.mypage a{color: inherit;text-decoration: none;padding: 30px 0;display: block;}
.mypage .icon{height: 50px;margin-top: 15px;}
.mypage i{font-size: 50px;}

.tit{margin-bottom: 30px;font-size: 24px;}
    </style>
</head>
<body>
<h1>My Page</h1>
<!-- <table> -->
<!-- 	<tr> -->
<!-- 		<th>회원정보 수정</th> -->
<!-- 		<th>찜목록</th> -->
<!-- 		<th>1:1 답변 보기</th> -->
<!-- 	</tr> -->
<!-- </table> -->
   <div class="mypage">
<!--       <h2 class="tit">My page</h2> -->

      <ul class="in">

            <li>
          <a href="view.do?id=${login.id }">
          <h3 class="t">회원정보 보기</h3>
          <div class="icon"><i class="fa fa-user" aria-hidden="true" style="color:#111"></i>
		</div>
          </a>
        </li>
        <li>
          <a href="chagePw.do?id=${login.id }">
          <h3 class="t">회원정보 수정</h3>
          <div class="icon"><i class="fa fa-user" aria-hidden="true" style="color:#111"></i>
		</div>
          </a>
        </li>
        <li>
          <a href="leave.do?id=${login.id }" onclick="if(!confirm('삭제 하시겠습니까?')) return false;">
          <h3 class="t">회원탈퇴</h3>
          <div class="icon"><i class="fa fa-user" aria-hidden="true" style="color:#c30b0b"></i></div>
          </a>
        </li>
       <li> 
          <a href="/qna/list.do?id=${login.id }">
          <h3 class="t">1:1 답변 보기</h3>
          <div class="icon"><i class="fa fa-commenting" aria-hidden="true" style="color:#159069"></i></div>
          </a>
        </li>
      </ul>
    </div>
</body>
</html>