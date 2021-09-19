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
import kr.or.bit.service.MemberDeleteService;
import kr.or.bit.service.MemberDetailService;
import kr.or.bit.service.MemberJoinService;
import kr.or.bit.service.MemberListService;
import kr.or.bit.service.MemberLoginService;
import kr.or.bit.service.MemberSearchService;
import kr.or.bit.service.MemberUpdateOkService;
import kr.or.bit.service.MemberUpdateService;
import kr.or.bit.service.board.BoardListService;

@WebServlet("*.bo")
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
