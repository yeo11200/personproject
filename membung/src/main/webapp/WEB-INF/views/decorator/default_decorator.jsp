<!-- sitemesh 사용을 위한 설정 파일 -->
<!-- 작성자 : 신진섭 -->
<!-- 작성일 : 2018-10-02 -->
<!-- 최종수정일 : 2018-10-02 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기있는 jstl은 여기에서만 사용을 할 수 있다. -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>분양::<decorator:title /></title>
	<!-- jQuery와 BootStrap을 등록했으므로 다른 jsp에쇼ㅓ는 등록하지 않고 사용한다. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	#maginDiv{
		margin-top: 15px;
	}
	#myPhoto{
		width: 80px;
		height: 50px;
	}
	#myInfo{
		color : #ddd;
	}
	#nav{
		background: #33cccc;
	}
/* 	#nav:hover{ */
/* 		color: #33cccc; */
/* 		text-decoration: underline; */
/* 	} */
	#navOut{
		margin-top: 80px;
	}
</style>
<c:if test="${!empty login }">
<script type="text/javascript">
	/* 로그인을 했다면 처음에 새로운 메시지를 확인하고 5초마다 한번씩 새로운 메시지가 있는지 확인하러간다.
	   호출을 해야 실행이 되는 메서드*/
	   function setMessageCnt(){
		// .load() : jquery의 Ajax 메서드 -> id가 messageCnt에다가 가져온 데이터를 올려놓은다.
		$("#messageCnt").load("/ajax/messageCnt.do");
		}
	$(function(){
		// 처음으로 한번 불러와서 데이터를 넣어준다.
		setMessageCnt();
		// 지정된 함수를 일정시간마다 실행하도록 설정해주는 함수 setInterval(function(){실행함수},시간);
		// 시간은 1000 == 1초
		var myVar = setInterval(function(){ setMessageCnt()},5000);
	});
</script>
</c:if>
</head>
<!-- 개별적으로 설정해 놓은 head tag부분을 끼워 넣기 해준다. -->
<decorator:head/>
<body style="height:1500px">
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="nav">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
                      
      </button>
      <a class="navbar-brand" href="/main/main.do">분양 사이트</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
      <li><a href="/sell/list.do">분양받기</a></li>
      <li><a href="/sellOut/list.do">분양하기</a></li>
      <li><a href="/find/list.do">찾기</a></li>
      <li><a href="/locate/list.do">찾아주기</a></li>
      <!-- 로그인 처리를해야만 하는 메뉴, 로그인을 하지 않으면 안보이도록 한다. -->
      <c:if test="${!empty login }">
      <li><a href="/message/list.do">메세지</a></li></c:if> 
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <!-- 위치를 지정하는 것 : navbar-right -->
 		<li><a href="/notice/list.do">공지사항</a></li>
      <li><a href="/qna/list.do">QNA</a></li>
      <li><a href="/board/list.do">자유게시판</a></li>
         	<!-- 로그인이 안되어 있는 상태 -->
    	<!-- 세선 로그인이 비어있다 -->
    <c:if test="${empty login }">
      <li><a href="/member/join.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/member/login.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </c:if>
     <c:if test="${!empty login && login.grade != 9}">
     <c:out value="${login.grade }"></c:out>
     <li><span id="myInfo">${login.name }(${login.id })</span>
     <span class="badge" id="messageCnt">1</span></li>
     <li><a href="/member/mypage.do"><span class="glyphicon glyphicon-user"></span> Mypage</a></li>
      <li><a href="/member/logout.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </c:if>
   	<c:if test="${!empty login && login.grade eq 9}">
     <li><span id="myInfo">나는 관리자</span>
     <span class="badge" id="messageCnt">1</span></li>
     <li><a href="/noticeMember/noticePage.do"><span class="glyphicon glyphicon-user"></span> Noticepage</a></li>
      <li><a href="/member/logout.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </c:if>
    </ul>
  </div>
 </div>
</nav>
		<div class="container" id="navOut">
		<decorator:body />
		<div id="maginDiv">
		</div>
		</div>
</body>
</html>