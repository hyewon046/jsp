<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>

<%
	String mbti = request.getParameter("ie")+request.getParameter("sn")
					+request.getParameter("tf")+request.getParameter("pj");
	
	out.print("당신의 MBTI는 " + mbti +  "입니다!");
	
	//.properties파일 읽기
	Properties props = new Properties();
	props.load(new FileReader("C:/Users/Administrator/git/jsp/jspbasic/src/main/webapp/jsp/mbti/mbti.properties"));
	
	Set entrySet = props.entrySet();
	Iterator it = entrySet.iterator();
	
	while(it.hasNext()) {
		Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
		if (entry.getKey().equals(mbti)) out.println(entry.getValue());
	}
%>