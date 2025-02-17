<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 작성폼</title>
</head>
<body>
<h3>게시글 작성</h3>
<form action="/insertArticle.do" method="post">
	게시판 번호 : <input type="text" name="bid"><br>
	회원아이디 : <input type="text" name="mid"><br>
	게시글 제목 : <input type="text" name="asubject"><br>
	게시글 내용 : <input type="text" name="acontent"><br>
	<input type="button" value="글 목록" onclick="location.href='/selectArticle.do';">&nbsp;
	<input type="submit" value="등록">
</form>
</body>
</html>