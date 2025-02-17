<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판 정보</title>
</head>
<body>
<h3>게시판 정보</h3>
<table>
	<tr>
		<td>게시판 번호</td>
		<td>${board.bid}</td>	
	</tr>
	<tr>
		<td>게시판명</td>
		<td>${board.bname}</td>	
	</tr>
	<tr>
		<td>게시글 수</td>
		<td>${board.bacnt}</td>	
	</tr>
</table>
<p><input type="button" value="목록" onclick="location.href='/selectBoard.do';"></p>
</form>
</body>
</html>