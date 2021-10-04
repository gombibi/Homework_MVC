package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.board.BoardContentService;
import kr.or.bit.service.board.BoardEditOkService;
import kr.or.bit.service.board.BoardEditService;
import kr.or.bit.service.board.BoardListService;
import kr.or.bit.service.board.BoardReplyOkService;
import kr.or.bit.service.board.BoardRewriteOkService;
import kr.or.bit.service.board.BoardRewriteService;
import kr.or.bit.service.board.BoardWriteOkService;
import kr.or.bit.service.board.ReplyDeleteOkService;

@WebServlet("*.bd")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontBoardController() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action=null;
    	ActionForward forward=null;
    	
    	if(url_Command.equals("/BoardList.bd")) { //게시판 목록
    		//UI+로직
    		action = new BoardListService();
    		forward = action.execute(request, response);
    		System.out.println("BoardListService 실행");
    		
    	}else if(url_Command.equals("/BoardWrite.bd")) { //게시판 글쓰기
    		//UI+로직
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("WEB-INF/views/board/Boardwrite.jsp");
    		
    	}
    	else if(url_Command.equals("/BoardWriteOk.bd")) { //게시판 글쓰기
    		//UI+로직
    		action = new BoardWriteOkService();
    		forward = action.execute(request, response);
    		System.out.println("BoardWriteOkService 실행");
    		
    	}else if(url_Command.equals("/BoardContent.bd")) { //게시판 글쓰기
    		//UI+로직
    		action = new BoardContentService();
    		forward = action.execute(request, response);
    		System.out.println("BoardContentService 실행");
    		
    	}else if(url_Command.equals("/BoardEdit.bd")) { //게시판 글쓰기
    		//UI+로직
    		action = new BoardEditService();
    		forward = action.execute(request, response);
    		System.out.println("BoardEditService 실행");
    		
    	}else if(url_Command.equals("/BoardEditOk.bd")) { //게시판 글쓰기
    		//UI+로직
    		action = new BoardEditOkService();
    		forward = action.execute(request, response);
    		System.out.println("BoardEditOkService 실행");
    		
    	}else if(url_Command.equals("/ReplyOk.bd")) { //게시판 글쓰기
    		//UI+로직
    		action = new BoardReplyOkService();
    		forward = action.execute(request, response);
    		System.out.println("BoardReplyOkService 실행");
    		
    	}else if(url_Command.equals("/ReplyDeleteOk.bd")) { //게시판 글쓰기
    		//UI+로직
    		action = new ReplyDeleteOkService();
    		forward = action.execute(request, response);
    		System.out.println("ReplyDeleteOkService 실행");
    		
    	}else if(url_Command.equals("/BoardRewrite.bd")) { //답글쓰기
    		//UI+로직
    		action = new BoardRewriteService();
    		forward = action.execute(request, response);
    		System.out.println("BoardRewriteService 실행");
    		
    	}else if(url_Command.equals("/BoardRewriteOk.bd")) { //답글쓰기
    		//UI+로직
    		action = new BoardRewriteOkService();
    		forward = action.execute(request, response);
    		System.out.println("BoardRewriteOkService 실행");
    		
    	}                            	    	

    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		}else { //false (모든 자원 ) 사용
    			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
