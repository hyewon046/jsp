<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판 추가</h3>
<form action="/insertBoard.do" method="post">
	게시판명 : <input type="text" name="bname"><br><br>
	<input type="button" value="목록" onclick="location.href='/selectBoard.do';" class="btn btn-info">&nbsp;
	<input type="submit" value="추가" class="btn btn-success">
</form>
<%@ include file="/jsp/include/footer.jsp" %>