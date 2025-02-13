<%@page import="jdbcboard.util.ConnectionUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Properties"%>

<%
	//out.print(((Properties)application.getAttribute("databaseProperties")).get("JDBC_URL")+"<br>");
	//out.print(((Properties)application.getAttribute("sqlProperties")).get("INSERT_MEMBER")+"<br>");
	//out.print(((Properties)application.getAttribute("appProp")).get("INSERT_MEMBER")+"<br>");
	//out.print(((Properties)application.getAttribute("appProp")).get("JDBC_URL")+"<br>");
%>

<%
	out.print(ConnectionUtil.getConnectionUtil().getConnection()); //connection은 static이 아니라서 실행할때마다 값이 달라짐
%>