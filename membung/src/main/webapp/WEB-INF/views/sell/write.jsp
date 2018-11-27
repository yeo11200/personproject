<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#patid{
		background: #ccc;
		margin-top: 20px;
	}
	#table{
		margin-top: 20px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
<label for="title">제목</label>
<input type="text" name="title" id="title" class="form-control">
<label for="writer">작성자</label>
<input type="text" value="${login.id }" readonly="readonly" id="id" name="writer" class="form-control">
<div align="center">
<table class="table" id="table">
<tbody>
	<tr>
		<td id="patid" align="center"><strong>견종</strong></td>
		<td><input type="text" name="patid" class="form-control"></td>
		<td id="patid" align="center"><strong>나이</strong></td>
		<td><input type="text" name="patage" class="form-control"></td>
	</tr>
	<tr>
		<td id="patid" align="center"><strong>성별</strong></td>
		<td><input type="text" name="patgender" class="form-control"></td>
		<td id="patid" align="center"><strong>색상</strong></td>
		<td><input type="text" name="patcolor" class="form-control"></td>
	</tr>
</tbody>
</table>
</div>
<label for="content">내용</label>
<textarea rows="4" cols="30" name="content" id="content" class="form-control">
</textarea>
<div id="fileDiv">
					<!-- input name은 DTO와 같게 해야한다. -->
					<!-- file 첨부인 경우 form tag에 enctype="multipart/form-data" -->
					<input name="multiFile"  class="form-control"
					required="required" type="file">
</div>
<button class="btn btn-warning">등록하기</button>
</form>
</body>
</html>