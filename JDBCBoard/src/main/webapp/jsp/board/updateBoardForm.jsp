<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판수정폼</title>
</head>
<body>
<h3>게시판 수정</h3>
<form action="/updateBoard.do" method="post">
<input type="hidden" name="bid" value="${board.bid}">
	게시판 번호 : ${board.bid} <br>
	게시판명 : <input type="text" name="bname" value="${board.bname}"><br>
	게시글 수 : ${board.bacnt}<br><br>
	<input type="button" value="목록" onclick="location.href='/selectBoard.do';">&nbsp;
	<input type="submit" value="수정">
</form>
</body>
</html>