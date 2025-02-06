<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>sn.jsp</title>
</head>
<body>
	<form action="tf.jsp" method="post">
	<input type="hidden" name="ie" value='<%=request.getParameter("ie")%>'> 
		<p>S 와 N 중 하나를 선택하세요!</p>
		<p>
			<input type="radio" name="sn" value="S">S(감각) &nbsp;
			<input type="radio" name="sn" value="N">N(직관) &nbsp;
		</p>
		<p><input type="submit" value="다음"></p>
	</form>
</body>
</html>