<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	//String[] hobbies = request.getParameterValues("hobby");
	//if (hobbies != null) {
		//for (String hobby : hobbies) {
			 //hobby= hobby + " "; //이렇게하면 이부분 처리가 안되미...
		//}
	//}
	//String hobby = "";
	//Enumeration en = request.getAttributeNames();
	//while(en.hasMoreElements()) {
		//hobby += request.getAttribute((String)en.nextElement())+" ";
	//}
	
	String[] hobbies = (String[])request.getAttribute("hobby");
	String strHobbies = "";
	for (String hobby : hobbies) {
		switch (hobby) {
			case "game":hobby="게임" ;break;
			case "youtube":hobby="유튜브시청" ;break;
			case "sleeping":hobby="잠자기" ;break;
		}
		strHobbies += hobby + " ";
	}

	out.print("설문조사 결과<br>");
	out.print("이름 : " + request.getAttribute("name") + "<br>");
	out.print("취미 : " + strHobbies);
%>