<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#startDate").datepicker({
		       changeMonth: true,
		       changeYear: true,
		       dateFormat: "yy-mm-dd",
		       onClose: function( selectedDate ) {
		           $( "#endDate" ).datepicker( "option", "minDate", selectedDate );
		       }
		 });
		 $("#endDate").datepicker({
			  changeMonth: true,
			  changeYear: true,
			  dateFormat: "yy-mm-dd",
			     minDate: 0,
			     onClose: function( selectedDate ) {
			         $( "#startDate" ).datepicker( "option", "maxDate", selectedDate );
			       }
			 });
	});
</script>
</head>
<body>
<form method="post">
<div>
	<label for="title">제목</label>
	<input name="title" id="title" class="form-control" value="${update.title }">
</div>
<div>
	<label for="content">내용</label>
	<textarea rows="20" cols="4" class="form-control" name="content" id="content">${update.content }</textarea>
</div>
<div>
<!-- value값을 안적어주고 실행을하니까 데이터가 안들어오는 게맞음 -->
	<label for="startDate">공지 시작일</label>
	<input name="startDate" class="form-control" id="startDate" value="<fmt:formatDate value="${update.startDate }" pattern="yyyy-MM-dd"/>">
</div>
<div>
<!-- value값을 안적어주고 실행을하니까 데이터가 안들어오는 게맞음 -->
	<label for="endDate">공지 시작일</label>
	<input name="endDate" class="form-control" id="endDate" value="<fmt:formatDate value="${update.endDate }" pattern="yyyy-MM-dd"/>">
</div>
<div>
<!-- value값을 안적어주고 실행을하니까 데이터가 안들어오는 게맞음 -->
	<label for="writeDate">공지 등록일</label>
	<input name="writeDate" class="form-control" id="writeDate" value="<fmt:formatDate value="${update.writeDate }" pattern="yyyy-MM-dd"/>">
</div>

<button class="btn btn-warning">등록</button>
<button class="btn btn-info" type="button" onclick="histroy.back()">돌아가기</button>
</form>
</body>
</html>