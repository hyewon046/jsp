<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ie.jsp</title>
</head>
<body>
	<form action="sn.jsp" method="post">
		<p>I 와 E 중 하나를 선택하세요!</p>
		<p>
			<input type="radio" name="ie" value="I">I(내향) &nbsp;
			<input type="radio" name="ie" value="E">E(외향) &nbsp;
		</p>
		<p><input type="submit" value="다음"></p>
	</form>
</body>
</html>