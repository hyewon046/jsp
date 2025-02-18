<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시물 목록폼</title>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
<h3>게시물 목록</h3>
<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성자</th>
			<th>등록일시</th>
			<th>첨부파일수</th>
		</tr>
	</thead>
	<c:if test="${!empty articleList}">
	<tbody>
		<c:forEach var="article" items="${articleList}">
		<tr>
			<td>${article.aid}</td>
			<td><a href="/getArticle.do?aid=${article.aid}">${article.asubject}</a></td>
			<td>${article.avcnt}</td>
			<td>${article.mid}</td>
			<td><fmt:formatDate value="${article.aregdate}" pattern="M/dd HH:mm" /></td>
			<td>${article.aafcnt}</td>

		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
	<p><input type="button" value="등록" onclick="location.href='/insertArticleForm.do';"></p>
</body>
</html>