<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 작성폼</title>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
<h3>게시글 작성</h3>
<form action="/insertArticle.do" method="post">
	<!-- 
	게시판 번호 : <input type="text" name="bid"><br>
	회원아이디 : <input type="text" name="mid"><br>
	 -->
	 <input type="hidden" name="mid" value="${sessionScope.ss_mid}">
	게시판 번호 : <input type="text" name="bid"><br>
	제목 : <input type="text" name="asubject"><br>
	내용 : <textarea rows="10" cols="40" name="acontent"></textarea><br>
	<input type="submit" value="등록">&nbsp;
	<input type="button" value="목록" onclick="location.href='/selectArticle.do';">
</form>
</body>
</html>