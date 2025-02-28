/*
 [Command Pattern 실습]
 MVC2프로젝트에서 command.properties를 제외하고 동일하게 작동하도록 구현
 
 요청 URI 활용하기(=요청 URI에서 커맨트클래스명을 만들어보자)
 */

package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import handler.CommandHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MVC2UseController extends HttpServlet{
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{

		String handlerClassStr=(String)request.getAttribute("handlerClassStr");
			
			CommandHandler handlerObj = null;
			try {
				Class handlerClass = Class.forName(handlerClassStr);
				handlerObj = (CommandHandler)handlerClass.newInstance();
			} catch (Exception ex){
				ex.printStackTrace();
			}
			
			//뷰페이지
			String viewPage = null;
			
			try {
				//명령어처리클래스의 객체에서 view페이지 획득
				viewPage = handlerObj.process(request, response);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			//뷰페이지가 존재한다면
			if(viewPage != null) {
				// 뷰페이지로 포워딩
				RequestDispatcher rd = request.getRequestDispatcher(viewPage);
				rd.forward(request, response);
			}
			
		} //processRequest
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			processRequest(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			processRequest(request, response);
		}
}//class
