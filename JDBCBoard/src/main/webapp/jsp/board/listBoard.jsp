<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판 목록</h3>
<table>
	<thead>
		<tr>
			<th>게시판 번호</th>
			<th>게시판 이름</th>
			<th>게시글 수</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	<c:if test="${!empty boardList}">
	<tbody>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td><a href="/getBoard.do?bid=${board.bid}">${board.bid}</a></td>
			<td>${board.bname}</td>
			<td>${board.bacnt}</td>
			<td>
				<input type="button" value="수정" onclick="location.href='/updateBoardForm.do?bid=${board.bid}';">&nbsp;
				<input type="button" value="삭제" onclick="location.href='/deleteBoard.do?bid=${board.bid}';">&nbsp;
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
	<p><input type="button" value="등록" onclick="location.href='/insertBoardForm.do';"></p>
</body>
</html>