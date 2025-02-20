<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시글 조회</h3>
<table class="table table-striped">
	<tr>
		<td>아이디</td>
		<td>${article.aid}</td>	
	</tr>
	<tr>
		<td>게시판</td>
		<td>${article.bname}</td>	
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
<c:if test="${!empty sessionScope.ss_mid}">
<p id="insertReply">
		<input type="text" name="rcontent">&nbsp;
		<input id="insertReplyBtn" type="button" value="등록" 
			data-mid="${sessionScope.ss_mid}"  data-aid="${article.aid}" class="btn btn-success btn-sm">
</p>
</c:if>
<ul id="replyList">
</ul>
  <div id="bar" class="btn-group me-2" role="group" aria-label="First group" >
    <button type="button" class="btn btn-outline-secondary btn-sm">1</button>
    <button type="button" class="btn btn-outline-secondary btn-sm">2</button>
    <button type="button" class="btn btn-outline-secondary btn-sm">3</button>
    <button type="button" class="btn btn-outline-secondary btn-sm">4</button>
  </div>
<br><p>
	<c:if test="${sessionScope.ss_mid == article.mid}">
	<input type="button" value="수정" onclick="location.href='/updateArticleForm.do?aid=${article.aid}';" class="btn btn-dark btn-sm">&nbsp;
	<input type="button" value="삭제" onclick="location.href='/deleteArticle.do?aid=${article.aid}';" class="btn btn-dark btn-sm">&nbsp;
	</c:if>
	<input type="button" value="목록" onclick="location.href='/selectArticle.do';" class="btn btn-info btn-sm">
</p>
<script>
$(function() {
	board.getReplyList('${article.aid}','${sessionScope.ss_mid}');
});
</script>	
<%@ include file="/jsp/include/footer.jsp" %>