<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판 목록</h3>
<table class="table table-hover">
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
			<td>${board.bid}</td>
			<td>${board.bname}</td>
			<td>${board.bacnt}</td>
			<td>
				<input type="button" value="수정" onclick="location.href='/updateBoardForm.do?bid=${board.bid}';" class="btn btn-secondary btn-sm">&nbsp;
				<input type="button" value="삭제" onclick="location.href='/deleteBoard.do?bid=${board.bid}';" class="btn btn-secondary btn-sm">&nbsp;
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
	<p id="insertP"><input id="insertBtn" type="button" value="등록" 
	data-mid="${sessionScope.ss_mid}" data-location="/insertBoardForm.do" class="btn btn-success"></p>
<%@ include file="/jsp/include/footer.jsp" %>