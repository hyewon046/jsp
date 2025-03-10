<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>회원 목록</h3>
<table class="table table-hover">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>별칭</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>삭제여부</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	<c:if test="${!empty memberList}">
	<tbody>
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td><a href='/getMember.do?mid=${member.mid}'>${member.mid}</a></td>
			<td>${member.mname}</td>
			<td>${member.malias}</td>
			<td>${member.memail}</td>
			<td>${member.mcp}</td>
			<td>${member.mdelyn}</td>
			<td>
				<input type="button" value="수정" onclick="location.href='/updateMemberForm.do?mid=${member.mid}';" class="btn btn-secondary btn-sm">&nbsp;
				<input type="button" value="삭제" onclick="location.href='/deleteMember.do?mid=${member.mid}';" class="btn btn-secondary btn-sm">&nbsp;
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
	<p id="insertP"><input id="insertBtn" type="button" value="등록" 
	data-mid="${sessionScope.ss_mid}" data-location="/insertMemberForm.do" class="btn btn-success"></p>
<%@ include file="/jsp/include/footer.jsp" %>