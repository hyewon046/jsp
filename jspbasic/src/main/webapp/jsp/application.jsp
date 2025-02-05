<%--
application : javax.servlet.ServletContext
- 어플리케이션 초기화 파라미터 
	: 어플리케이션이 초기화될때 저장되는 변수, 전체 서블릿들이 값을 공유하는 변수
- getInitParameter(파라미터명) : 어플리케이션 초기화 파라미터 값 획득
- getInitParameterNames() : 어플리케이션 초기화 파라미터명들을 획득
- getRealPath(경로) : 경로에 해당하는 파일의 서버상의 실제 위치 (파일다운로드)
- getResourceAsStream(경로) : 경로에 해당하는 파일의 InputStream 획득 (파일다운로드)
--%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	out.print(application.getInitParameter("appname")+"<br>");

	Enumeration en = application.getInitParameterNames();
	while(en.hasMoreElements()) {
		String element = (String)en.nextElement(); //원래 형태는 Object
		out.print("변수명 : " + element + ", ");
		out.print("변수값 : " + application.getInitParameter(element)+"<br>");
	}
	
	out.print(application.getRealPath("/jsp/application.jsp")+"<br>");
	
	//여기에 적는 코드는 service 메소드 안에 있는데 service가 예외처리를 던지고 있어서 예외처리를 여기서는 안해도됨
	InputStream is = application.getResourceAsStream("/jsp/application.jsp"); 
	
	//실습 : 파일의 문자들을 화면에 출력해보기
	InputStreamReader isr = new InputStreamReader(is); //바이트 입력스트림을 문자입력스트림으로 변환 
	BufferedReader br = new BufferedReader(isr);
	String line = "";
	while ((line=br.readLine()) != null) {
		System.out.print(line + "<br>");
	}
	
%>

<button onclick="location.href='/jsp/imgdownload.jsp';">이미지 다운로드</button>
