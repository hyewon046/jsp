<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String name = request.getParameter("name");
	request.setAttribute("name", name);
	
	request.getRequestDispatcher("survey2.jsp").forward(request,response);
%>