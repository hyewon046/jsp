package jdbcboard.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbcboard.model.Article;
import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.impl.ArticleServiceImpl;
import jdbcboard.service.impl.BoardServiceImpl;
import jdbcboard.service.impl.MemberServiceImpl;
import jdbcboard.service.impl.ReplyServiceImpl;

public class JDBCBoardController extends HttpServlet{
	//파라미터들 나중에 바꿔서 이 파일은 전버전이라 안바뀌어서 에러남
	
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
		int result = 0;
		String viewPage = (String)request.getAttribute("viewPage");
		
		System.out.println(requestURI);
		System.out.println(viewPage);
		
		Member member = null;
		Board board = null;
		Article article = null;
		
		
		switch (requestURI) {
		
		case "selectMember.do":
				resultObj = MemberServiceImpl.getMemberServiceImpl().selectMember();
				request.setAttribute("memberList", resultObj);
			break;
		case "getMember.do":
			resultObj = MemberServiceImpl.getMemberServiceImpl().getMember(request.getParameter("mid"));
			request.setAttribute("member", resultObj);
			break;	
		case "insertMember.do":
			member = new Member(
					request.getParameter("mid"),
					request.getParameter("mname"),
					request.getParameter("malias"),
					request.getParameter("mpass"),
					request.getParameter("memail"),
					request.getParameter("mcp"),
					"N"
			);
			MemberServiceImpl.getMemberServiceImpl().insertMember(member);
			response.sendRedirect("/selectMember.do");
			break;
			
		case "updateMemberForm.do" : 
			resultObj = MemberServiceImpl.getMemberServiceImpl().getMember(request.getParameter("mid"));
			request.setAttribute("member", resultObj);
			break;
		case "updateMember.do" :
			member = new Member(
					request.getParameter("mid"),
					request.getParameter("mname"),
					null,
					request.getParameter("malias"),
					request.getParameter("memail"),
					request.getParameter("mcp"),
					"N"
			);
			MemberServiceImpl.getMemberServiceImpl().updateMember(member);
			response.sendRedirect("/selectMember.do");
			break;
		case "deleteMember.do" : 
			MemberServiceImpl.getMemberServiceImpl().deleteMember(request.getParameter("mid"));
			response.sendRedirect("/selectMember.do");
			break;
		case "selectBoard.do":
			resultObj = BoardServiceImpl.getBoardServiceImpl().selectBoard();
			request.setAttribute("boardList", resultObj);
			break;
		case "getBoard.do":
			resultObj = BoardServiceImpl.getBoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
			request.setAttribute("board", resultObj);
			break;	
		case "insertBoard.do" :
			board = new Board(0, request.getParameter("bname"),0);
			BoardServiceImpl.getBoardServiceImpl().insertBoard(board);
			response.sendRedirect("/selectBoard.do");
			break;
		case "updateBoardForm.do" :
			resultObj = BoardServiceImpl.getBoardServiceImpl().getBoard(Integer.parseInt(request.getParameter("bid")));
			request.setAttribute("board", resultObj);
			break;
		case "updateBoard.do" : 
			board = new Board(Integer.parseInt(request.getParameter("bid")), request.getParameter("bname"), 0);
			BoardServiceImpl.getBoardServiceImpl().updateBoard(board);
			response.sendRedirect("/selectBoard.do");
			break;
		case "deleteBoard.do" :
			BoardServiceImpl.getBoardServiceImpl().deleteBoard(
					Integer.parseInt(request.getParameter("bid"))
			);
			response.sendRedirect("/selectBoard.do");
			break;
		case "selectArticle.do":
			resultObj = ArticleServiceImpl.getArticleServiceImpl().selectArticle();
			request.setAttribute("articleList", resultObj);
			break;
		case "getArticle.do":
			resultObj = ArticleServiceImpl.getArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
			request.setAttribute("article", resultObj);
			break;	
		case "insertArticle.do" :
			article = new Article(
					0,
					request.getParameter("asubject"),
					request.getParameter("acontent"),
					0,
					null,
					"N",
					0,
					0,
					Integer.parseInt(request.getParameter("bid")),
					request.getParameter("mid")
			);
			ArticleServiceImpl.getArticleServiceImpl().insertArticle(article);
			response.sendRedirect("/selectArticle.do");
			break;
		case "updateArticleForm.do" : 
			resultObj = ArticleServiceImpl.getArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
			request.setAttribute("article", resultObj);
			break;
		case "updateArticle.do" : 
			article = new Article(
					Integer.parseInt(request.getParameter("aid")),
					request.getParameter("asubject"),
					request.getParameter("acontent"),
					0,
					null,
					"N",
					0,
					0,
					0,
					null
			);
			ArticleServiceImpl.getArticleServiceImpl().updateArticle(article);
			response.sendRedirect("/selectArticle.do");
			break;
		case "deleteArticle.do" : 
			ArticleServiceImpl.getArticleServiceImpl().deleteArticle(Integer.parseInt(request.getParameter("aid")));
			response.sendRedirect("/selectArticle.do");
			break;
		case "selectReply.do" :
			resultObj = ReplyServiceImpl.getReplyServiceImpl().selectReply();
			request.setAttribute("replyList", resultObj);
			break;
		case "insertReply.do" :
			Reply reply = new Reply(
					0,
					request.getParameter("rcontent"),
					null,
					"N",
					request.getParameter("mid"),
					Integer.parseInt(request.getParameter("aid"))
			);
			result = ReplyServiceImpl.getReplyServiceImpl().insertReply(reply);
			request.setAttribute("result", result);
			break;
		case "deleteReply.do" :
			result = ReplyServiceImpl.getReplyServiceImpl().deleteReply(Integer.parseInt(request.getParameter("rid")));
			request.setAttribute("result", result);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
