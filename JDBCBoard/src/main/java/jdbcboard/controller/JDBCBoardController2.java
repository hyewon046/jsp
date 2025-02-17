package jdbcboard.controller;

import java.io.IOException;
import java.io.Serializable;

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

public class JDBCBoardController2 extends HttpServlet implements Serializable {
   
   private static final long serialVersionUID = 239487932473924L;
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
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
      
      Member member = null;
      Board board = null;
      Article article = null;
      Reply reply = null;
      
      switch (requestURI) {
      
         case "selectMember.do":
            resultObj = MemberServiceImpl.getMemberServiceImpl().selectMember();
            request.setAttribute("memberList", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "getMember.do":
            resultObj = MemberServiceImpl.getMemberServiceImpl().getMember(request.getParameter("mid"));
            request.setAttribute("member", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "insertMemberForm.do":
            response.sendRedirect(viewPage);
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
            
         case "updateMemberForm.do":
            resultObj = MemberServiceImpl.getMemberServiceImpl().getMember(request.getParameter("mid"));
            request.setAttribute("member", resultObj);   
            forward(request, response, viewPage);
            break;
            
         case "updateMember.do":
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
            
         case "deleteMember.do":
            MemberServiceImpl.getMemberServiceImpl().deleteMember(request.getParameter("mid"));
            response.sendRedirect("/selectMember.do");
            break;
            
         case "selectBoard.do":
            resultObj = BoardServiceImpl.getBoardServiceImpl().selectBoard();
            request.setAttribute("boardList", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "insertBoardForm.do":
            response.sendRedirect(viewPage);
            break;            
            
         case "insertBoard.do":
            board = new Board(0, request.getParameter("bname"), 0);
            BoardServiceImpl.getBoardServiceImpl().insertBoard(board);
            response.sendRedirect("/selectBoard.do");
            forward(request, response, viewPage);
            break;
            
         case "updateBoardForm.do":
            int bid = Integer.parseInt(request.getParameter("bid"));
            resultObj = BoardServiceImpl.getBoardServiceImpl().getBoard(bid);
            request.setAttribute("board", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "updateBoard.do":
            board = new Board(
               Integer.parseInt(request.getParameter("bid")), 
               request.getParameter("bname"), 
               0
            );
            BoardServiceImpl.getBoardServiceImpl().updateBoard(board);
            response.sendRedirect("/selectBoard.do");
            break;
            
         case "deleteBoard.do":
            result = BoardServiceImpl.getBoardServiceImpl().deleteBoard(
               Integer.parseInt(request.getParameter("bid"))
            );
            response.sendRedirect("/selectBoard.do");   
            break;
            
         case "selectArticle.do":
            resultObj = ArticleServiceImpl.getArticleServiceImpl().selectArticle();
            request.setAttribute("articleList", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "getArticle.do":
            int aid = Integer.parseInt(request.getParameter("aid"));
            resultObj = ArticleServiceImpl.getArticleServiceImpl().getArticle(aid);
            request.setAttribute("article", resultObj);
            forward(request, response, viewPage);
            break;
            
         case "insertArticle.do":
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
            result = ArticleServiceImpl.getArticleServiceImpl().insertArticle(article);
            request.setAttribute("result", result);
            response.sendRedirect("/selectArticle.do");   
            break;
            
 		case "updateArticleForm.do" : 
			resultObj = ArticleServiceImpl.getArticleServiceImpl().getArticle(Integer.parseInt(request.getParameter("aid")));
			request.setAttribute("article", resultObj);
			forward(request, response, viewPage);
			break;
            
         case "updateArticle.do":
            article = new Article(
                  0,
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
            result = ArticleServiceImpl.getArticleServiceImpl().updateArticle(article);
            request.setAttribute("result", result);
            response.sendRedirect("/selectArticle.do");
            break;
            
         case "deleteArticle.do":
            result = ArticleServiceImpl.getArticleServiceImpl().deleteArticle(
               Integer.parseInt(request.getParameter("aid"))
            );
            request.setAttribute("result", result);
            response.sendRedirect("/selectArticle.do");
            break;
            
         case "selectReply.do":
            resultObj = ReplyServiceImpl.getReplyServiceImpl().selectReply();
            request.setAttribute("resultObj", resultObj);
            break;
            
         case "insertReply.do":
            reply = new Reply(
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
            
         case "deleteReply.do":
            result = ReplyServiceImpl.getReplyServiceImpl().deleteReply(Integer.parseInt("rid"));
            request.setAttribute("result", result);
            break;
            
      }
      
   } // process
   
   private void forward(HttpServletRequest request, HttpServletResponse response, 
         String viewPage) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher(viewPage);
      rd.forward(request, response);      
   }

} // class

