<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ie.jsp</title>
</head>
<body>
	<form action="result.jsp" method="post">
		<input type="hidden" name="ie" value='<%=request.getParameter("ie")%>'>
	<input type="hidden" name="sn" value='<%=request.getParameter("sn")%>'> 
	<input type="hidden" name="tf" value='<%=request.getParameter("tf")%>'> 
		<p>I 와 E 중 하나를 선택하세요!</p>
		<p>
			<input type="radio" name="pj" value="P">P(인식) &nbsp;
			<input type="radio" name="pj" value="J">J(판단) &nbsp;
		</p>
		<p><input type="submit" value="결과보기"></p>
	</form>
</body>
</html>