<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 수정폼</title>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
<h3>게시글 수정</h3>
<form action="/updateArticle.do" method="post">
	<input type="hidden" name="aid" value="${article.aid}">
	제목 : <input type="text" name="asubject" value="${article.asubject}"><br>
	내용 : <textarea rows="10" cols="40" name="acontent">${article.acontent}</textarea><br>
	<input type="submit" value="수정">&nbsp;
	<input type="button" value="목록" onclick="location.href='/selectArticle.do';">
</form>
</body>
</html>