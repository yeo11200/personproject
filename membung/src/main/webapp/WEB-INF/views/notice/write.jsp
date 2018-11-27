<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 여기에 있는 스크립트와 스타일을 사용해야 달력이 표시된다. -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>
<body>
<form method="post">
<div>
	<label for="title">제목</label>
	<input name="title" id="title" class="form-control">
</div>
<div>
	<label for="content">내용</label>
	<textarea rows="20" cols="4" class="form-control" name="content" id="content"></textarea>
</div>
<div>
	<label for="startDate">공지 시작일</label>
	<input name="startDate" class="form-control" id="startDate">
</div>
<div>
	<label for="endDate">공지 시작일</label>
	<input name="endDate" class="form-control" id="endDate">
</div>
<div>
	<label for="writeDate">공지 등록일</label>
	<input name="writeDate" class="form-control" id="writeDate">
</div>

<button class="btn btn-warning">등록</button>
<button class="btn btn-info" type="button" onclick="history.back()">돌아가기</button>
</form>
</body>
</html>