<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 목록폼</title>
</head>
<body>
<h3>게시글 목록</h3>
<table>
	<thead>
		<tr>
			<th>게시글 번호</th>
			<th>게시판 번호</th>
			<th>회원아이디</th>
			<th>작성시간</th>
			<th>제목</th>
			<th>내용</th>
			<th>조회수</th>
			<th>첨부파일수</th>
			<th>삭제여부</th>
			<th>댓글수</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	<c:if test="${!empty articleList}">
	<tbody>
		<c:forEach var="article" items="${articleList}">
		<tr>
			<td><a href="/getArticle.do?aid=${article.aid}">${article.aid}</a></td>
			<td>${article.bid}</td>
			<td>${article.mid}</td>
			<td>${article.aregdate}</td>
			<td>${article.asubject}</td>
			<td>${article.acontent}</td>
			<td>${article.avcnt}</td>
			<td>${article.aafcnt}</td>
			<td>${article.adelyn}</td>
			<td>${article.arcnt}</td>
			<td>
				<input type="button" value="수정" onclick="location.href='/updateArticleForm.do?aid=${article.aid}';">&nbsp;
				<input type="button" value="삭제" onclick="location.href='/deleteArticle.do?aid=${article.aid}';">&nbsp;
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
	<p><input type="button" value="등록" onclick="location.href='/insertArticleForm.do';"></p>
</body>
</html>