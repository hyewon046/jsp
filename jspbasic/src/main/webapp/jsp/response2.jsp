<%@ page contentType="text/html; charset=UTF-8"%>

<%
	//응답 전환
	//원래 response2.jsp호출시 response2.jsp가 실행되어야하지만
	//리다이렉션을 하면 response3.jsp가 실행되어 클라이언트에게 응답함
	
	System.out.println(request);
	request.setAttribute("name", "홍길동");

	//리다이렉션
	//클라이언트에게 새로운 요청을 하도록 함 => 주소창의 주소가 변경됨
	//response.sendRedirect("response3.jsp");
	
	//포워딩
	//클라이언트는 원래의 요청밖에 모름 => 주소창의 주소가 변경 안됨
	RequestDispatcher rd = request.getRequestDispatcher("response3.jsp");
	rd.forward(request, response);
%>

<%="response2.jsp"%>