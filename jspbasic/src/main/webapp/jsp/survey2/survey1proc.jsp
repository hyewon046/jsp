<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:forward page="survey2.jsp">
	<jsp:param value="<%=request.getParameter(\"name\")%>" name="name"/>
</jsp:forward>