<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>select</title>
</head>
<body>
<c:forEach var="dto" items="${list}">
번호 : ${dto.sid}, 
제목 : <a href="/get.do?sid=${dto.sid}">${dto.title}</a>, 
내용 : ${dto.content}
<a href="/updateForm.do?sid=${dto.sid}">[수정]</a>
<a href="/delete.do?sid=${dto.sid}">[삭제]</a>
<br>
</c:forEach>
<a href="/insertForm.do">등록</a>
</body>
</html>