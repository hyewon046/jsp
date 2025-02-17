<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 정보</title>
</head>
<body>
<h3>게시글 정보</h3>
<table>
	<tr>
		<td>게시판 번호</td>
		<td>${article.bid}</td>	
	</tr>
	<tr>
		<td>회원아이디</td>
		<td>${article.mid}</td>	
	</tr>
	<tr>
		<td>작성시간</td>
		<td>${article.aregdate}</td>	
	</tr>
	<tr>
		<td>게시글 번호</td>
		<td>${article.aid}</td>	
	</tr>
	<tr>
		<td>제목</td>
		<td>${article.asubject}</td>	
	</tr>
	<tr>
		<td>내용</td>
		<td>${article.acontent}</td>	
	</tr>
	<tr>
		<td>조회수</td>
		<td>${article.avcnt}</td>	
	</tr>
	<tr>
		<td>첨부파일수</td>
		<td>${article.aafcnt}</td>	
	</tr>
	<tr>
		<td>삭제여부</td>
		<td>${article.adelyn}</td>	
	</tr>
	<tr>
		<td>댓글수</td>
		<td>${article.arcnt}</td>	
	</tr>

</table>
<p><input type="button" value="목록" onclick="location.href='/selectMember.do';"></p>
</form>
</body>
</html>