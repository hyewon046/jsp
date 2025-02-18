<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<header>
	<p>
		<a href="/selectMember.do">회원관리</a>&nbsp;
		<a href="/selectBoard.do">게시판관리</a>&nbsp;
		<a href="/selectArticle.do">게시물관리</a>&nbsp;
	</p>
	<p>
		<c:if test="${empty  sessionScope.ss_mid}">
		<form name="loginForm" action="/login.do" method="post">
			아이디 <input type="text" name="mid">&nbsp;
			비밀번호 <input type="text" name="mpass">&nbsp;
			<input type="submit" value="로그인">&nbsp;
			<input type="button" value="회원가입" onclick="location.href='/insertMemberForm.do';">
		</form>
		</c:if>
		<c:if test="${!empty sessionScope.ss_mid}">
			${sessionScope.ss_mid}님 로그인 중!&nbsp;
			<input type="button" value="로그아웃" onclick="location.href='/logout.do';">
		</c:if>
	</p>
</header>