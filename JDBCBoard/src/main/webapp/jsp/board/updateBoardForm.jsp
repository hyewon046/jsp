<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판 수정</h3>
<form action="/updateBoard.do" method="post">
<input type="hidden" name="bid" value="${board.bid}">
	게시판 번호 : ${board.bid} <br>
	게시판명 : <input type="text" name="bname" value="${board.bname}"><br>
	게시글 수 : ${board.bacnt}<br><br>
	<input type="button" value="목록" onclick="location.href='/selectBoard.do';" class="btn btn-info btn-sm">&nbsp;
	<input type="submit" value="수정" class="btn btn-secondary btn-sm">
</form>
<%@ include file="/jsp/include/footer.jsp" %>