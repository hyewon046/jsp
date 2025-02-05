<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%	
	request.setAttribute("name", request.getParameter("name"));
	request.setAttribute("hobby", request.getParameterValues("hobby"));

	RequestDispatcher rd = request.getRequestDispatcher("surveyresult.jsp");
	rd.forward(request,response);
%>