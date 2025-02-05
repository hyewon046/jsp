<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>

<%
	//실습2 : 이미지 다운로드 구현
	InputStream is = application.getResourceAsStream("/img/winter.jpg");
	//InputStreamReader isr = new InputStreamReader(is);
	//BufferedReader br = new BufferedReader(isr);
	
	//다운로드시 응답헤더 설정
	response.setHeader("Content-Disposition", "attachment; filename=\"winter.jpg\"");
	OutputStream os = response.getOutputStream();
	
	byte[] buffer = new byte[1024];
	int readCount = 0;
	while ((readCount=is.read(buffer)) > 0) {
		os.write(buffer, 0, readCount);
	}
%>
