<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>survey1.jsp</title>
</head>
<body>
	<form action="survey2proc.jsp" method="post">
	<input type="hidden" name="name" value='<%=request.getAttribute("name")%>'> <!-- survey2로 넘어오면서 request가 바뀌어서 한번더 가지고옴 -->
		<p>취미를 선택하세요!</p>
		<p>
			<input type="checkbox" name="hobby" value="game">게임&nbsp;
			<input type="checkbox" name="hobby" value="youtube">유튜브시청&nbsp;
			<input type="checkbox" name="hobby" value="sleeping">잠자기
		</p>
		<p><input type="submit" value="다음"></p>
	</form>
</body>
</html>