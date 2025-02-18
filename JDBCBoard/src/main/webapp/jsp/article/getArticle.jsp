<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.9/dayjs.min.js"></script>
<script defer src="../js/board.js"></script>
</head>
<body>
<h3>게시글 조회</h3>
<table>
	<tr>
		<td>아이디</td>
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
		<td>작성자</td>
		<td>${article.mid}</td>	
	</tr>
	<tr>
		<td>등록일시</td>
		<td><fmt:formatDate value="${article.aregdate}" pattern="yyyy/M/dd HH:mm:ss"/></td>	
	</tr>
	<tr>
		<td>첨부파일수</td>
		<td>${article.aafcnt}</td>	
	</tr>
</table>
<ul id="replyList">
</ul>
<p>
	<input type="button" value="수정" onclick="location.href='/updateArticleForm.do?aid=${article.aid}';">&nbsp;
	<input type="button" value="삭제" onclick="location.href='/deleteArticle.do?aid=${article.aid}';">&nbsp;
	<input type="button" value="목록" onclick="location.href='/selectArticle.do';">
</p>
<script>
$(function() {
	board.getReplyList('${article.aid}');
});
</script>	
</body>
</html>