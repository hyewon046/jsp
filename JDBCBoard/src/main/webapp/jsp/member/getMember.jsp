<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<h3>회원 정보</h3>
<table>
	<tr>
		<td>아이디</td>
		<td>${member.mid}</td>	
	</tr>
	<tr>
		<td>이름</td>
		<td>${member.mname}</td>	
	</tr>
	<tr>
		<td>별칭</td>
		<td>${member.malias}</td>	
	</tr>
	<tr>
		<td>이메일</td>
		<td>${member.memail}</td>	
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${member.mcp}</td>	
	</tr>
	<tr>
		<td>삭제여부</td>
		<td>${member.mdelyn}</td>	
	</tr>
</table>
<p><input type="button" value="목록" onclick="location.href='/selectMember.do';"></p>
</form>
</body>
</html>