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
import kr.or.bit.service.member.MemberDeleteService;
import kr.or.bit.service.member.MemberDetailService;
import kr.or.bit.service.member.MemberIdCheckService;
import kr.or.bit.service.member.MemberJoinService;
import kr.or.bit.service.member.MemberListService;
import kr.or.bit.service.member.MemberLoginService;
import kr.or.bit.service.member.MemberSearchService;
import kr.or.bit.service.member.MemberUpdateOkService;
import kr.or.bit.service.member.MemberUpdateService;

@WebServlet("*.me")
public class FrontMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontMemberController() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action=null;
    	ActionForward forward=null;
    	
    	if(url_Command.equals("/JoinOK.me")) { //회원가입
    		//UI+로직
    		action = new MemberJoinService();
    		forward = action.execute(request, response);
    		System.out.println("MemberJoinService 실행");
    		
    	}else if(url_Command.equals("/LoginIdCheck.me")) { //비동기(ID 사용 유무)
    		action = new MemberIdCheckService();
    		forward = action.execute(request, response);
    		System.out.println("MemberIdCheckService 실행");
    	
    	}else if(url_Command.equals("/LoginOK.me")) { //로그인
    		//UI+로직
    		action = new MemberLoginService();
    		forward = action.execute(request, response);
    		System.out.println("MemberLoginService 실행");
    		
    	}else if(url_Command.equals("/Memberlist.me")) { //관리자 회원리스트
    		//UI+로직
    		action = new MemberListService();
    		forward = action.execute(request, response);
    		System.out.println("MemberListService 실행");
    		
    	}else if(url_Command.equals("/MemberDelete.me")) { //회원 삭제
    		//UI+로직
    		action = new MemberDeleteService();
    		forward = action.execute(request, response);
    		System.out.println("MemberDeleteService 실행");
    	
    	}else if(url_Command.equals("/MemberUpdate.me")) { //회원 업데이트 페이지 이동
    		//UI+로직
    		action = new MemberUpdateService();
    		forward = action.execute(request, response);
    		System.out.println("MemberUpdateService 실행");
    		
    	}else if(url_Command.equals("/MemberUpdateOk.me")) { //회원 업데이트
    		//UI+로직
    		action = new MemberUpdateOkService();
    		forward = action.execute(request, response);
    		System.out.println("MemberUpdateOkService 실행");
    		
    	}else if(url_Command.equals("/MemberDetail.me")) { //회원 업데이트
    		//UI+로직
    		action = new MemberDetailService();
    		forward = action.execute(request, response);
    		System.out.println("MemberDetailService 실행");
    		
    	}else if(url_Command.equals("/MemberSearch.me")) { //회원 검색
    		//UI+로직
    		action = new MemberSearchService();
    		forward = action.execute(request, response);
    		System.out.println("MemberSearchService 실행");
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
