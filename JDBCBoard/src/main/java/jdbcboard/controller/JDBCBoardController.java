package jdbcboard.controller;

import java.io.IOException;
import java.util.function.DoubleToIntFunction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbcboard.model.Member;
import jdbcboard.service.impl.ArticleServiceImpl;
import jdbcboard.service.impl.BoardServiceImpl;
import jdbcboard.service.impl.MemberServiceImpl;

public class JDBCBoardController extends HttpServlet{
	
	//컨트롤러의 역할
	//1. 요청을 받아 서비스를 호출
	//2. 서비스의 결과를 request에 저장
	//3. 결과를 보여줄 뷰를 포워딩
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println(request.getAttribute("viewPage"));
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI = (String)request.getAttribute("requestURI");
		Object resultObj = null;
		String viewPage = (String)request.getAttribute("viewPage");
		
		System.out.println(requestURI);
		System.out.println(viewPage);
		
		switch (requestURI) {
		
		case "selectMember.do":
				resultObj = new MemberServiceImpl().selectMember();
				request.setAttribute("memberList", resultObj);
			break;
		case "getMember.do":
			resultObj = new MemberServiceImpl().getMember(request.getParameter("mid"));
			request.setAttribute("member", resultObj);
			break;
		case "selectBoard.do":
			resultObj = new BoardServiceImpl().selectBoard();
			request.setAttribute("boardList", resultObj);
			break;
		case "getBoard.do":
			resultObj = new BoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
			request.setAttribute("board", resultObj);
			break;	
		case "selectArticle.do":
			resultObj = new ArticleServiceImpl().selectArticle();
			request.setAttribute("articleList", resultObj);
			break;
		case "getArticle.do":
			resultObj = new ArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
			request.setAttribute("article", resultObj);
			break;	

		case "insertMemberForm.do":
			Member member =null;
			resultObj = new MemberServiceImpl().insertMember(member);
			member.setMid(request.getParameter("mid"));
			request.setAttribute("insertMember", resultObj);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
		
	}

}
