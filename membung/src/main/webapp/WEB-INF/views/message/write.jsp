<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 보내기</title>
</head>
<body>
<h1>메시지 보내기</h1>
<div>
	<form method="post">
	
		<table class="table">
		<tbody>
			<!-- 보내는 사람은 controller에서 session에서 받아야 한다.
			     현재는 로그인 처리가 되어 있지 않으므로 입력하는 것으로 하자. -->
			<tr>
				<th>받는 사람</th>
				<td>
				<!-- required="required" : 필수입력 -->
				<!-- bootStrap 입력 스타일 적용을 위해 class="form-control" -->
					<input name="accepter" id="accepter" class="form-control"
					 required="required" pattern="[a-zA-Z0-9]{4,20}"
					 maxlength="20" />
				</td>
			</tr>
			<tr>
				<th>메시지</th>
				<td><textarea rows="5" cols="60" class="form-control"
					 name="content"></textarea></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
		<!-- 	위의 내용이 한중에 2칸을 사용하고 있기 때문에 2칸을 한 칸으로 합쳐야 한다. -> colspan -->
				<td colspan="2">
			<!-- 	button tag의 기본 type은 submit 이므로 생략 할 수 있다. -->
					<button type="submit">보내기</button>
					<button type="reset">새로입력</button>
					<button type="button" onclick="history.back()">취소</button>
				</td>
			</tr>
		</tfoot>
		</table>
		
	</form>
</div>
</body>
</html>