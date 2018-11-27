<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>문의 수정</h2>
  <form method="post">
    <div class="form-group">
      <label for="no">글번호</label>
      <input type="text" class="form-control" id="no" name="no" readonly="readonly"
      value="${quest.no }">
      </div>
<!-- readonly 속성을 이용해서 변경 불가능한 데이터 전송 -->
    <div class="form-group">
      <label for="title">제목</label>
<!--      placeholer 속성 입력한 데이터가 없는 경우에 배경으로 나타난다
<!-- 실제로 입력을 100자까지로 지정 -->
<!-- required 속성을 설정하면 필수입력 사항이 된다.  -->
<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
      <input type="text" class="form-control" id="title" placeholder="제목 입력(4-100)" name="title" maxlength="30" required="required"
      pattern=".{4,100}" value="${quest.title }">
      </div>
      
    <div class="form-group">
      <label for="content">내용</label>
<!--       여러줄의 데이터를 입력하고자 할때 textarea 태그를 사용한다 -->
<!-- textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
      <textarea class="form-control" rows="5" id="content" name="questContent" placeholder="내용을 작성해주세욥">${quest.questContent }</textarea></div>
      
    <div class="form-group">
      <label for="writer">작성자</label>
      <input type="text" class="form-control" id="writer" name="writer" value="${quest.writer }" readonly="readonly"></div>

      <button type="submit" class="btn btn-default">등록</button>
      <button type="reset" class="btn btn-default">새로입력</button>
      <button type="button" class="btn btn-default" onclick="location='list.do'">취소</button>
 </form>
</div>
</body>
</html>