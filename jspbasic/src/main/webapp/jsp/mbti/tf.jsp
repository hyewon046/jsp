<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ie.jsp</title>
</head>
<body>
	<form action="pj.jsp" method="post">
	<input type="hidden" name="ie" value='<%=request.getParameter("ie")%>'>
	<input type="hidden" name="sn" value='<%=request.getParameter("sn")%>'> 
		<p>I 와 E 중 하나를 선택하세요!</p>
		<p>
			<input type="radio" name="tf" value="T">T(사고) &nbsp;
			<input type="radio" name="tf" value="F">F(감정) &nbsp;
		</p>
		<p><input type="submit" value="다음"></p>
	</form>
</body>
</html>