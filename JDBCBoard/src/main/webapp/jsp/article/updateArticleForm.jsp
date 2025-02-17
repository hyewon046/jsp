<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 수정폼</title>
</head>
<body>
<h3>게시글 수정</h3>
<form action="/updateArticle.do" method="post">
<input type="hidden" name="aid" value="${article.aid}">
	게시글 번호 : ${article.aid}<br>
	게시판 번호 : ${article.bid}<br>
	회원아이디 : ${article.mid}<br>
	작성시간 : ${article.aregdate}<br>
	게시글 제목 : <input type="text" name="asubject" value="${article.asubject}"><br>
	게시글 내용 : <input type="text" name="acontent" value="${article.acontent}"><br>
	조회수 : ${article.avcnt}<br>
	첨부파일수 : ${article.aafcnt}<br>
	삭제여부 : ${article.adelyn}<br>
	댓글수 : ${article.arcnt}<br>
	<input type="button" value="글 목록" onclick="location.href='/selectArticle.do';">&nbsp;
	<input type="submit" value="수정">
</form>
</body>
</html>