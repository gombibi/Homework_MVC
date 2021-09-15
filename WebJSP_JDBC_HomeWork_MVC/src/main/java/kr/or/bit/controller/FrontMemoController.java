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
import kr.or.bit.service.MemoAddService;
import kr.or.bit.service.MemoDeleteService;
import kr.or.bit.service.MemoIdCheckService;
import kr.or.bit.service.MemoListService;
import kr.or.bit.service.MemoUpdateRunService;
import kr.or.bit.service.MemoUpdateService;
import kr.or.bit.service.MemoViewService;




@WebServlet("*.memo")
public class FrontMemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontMemoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action=null;
    	ActionForward forward=null;
    	
    	if(url_Command.equals("/MemoAdd.memo")) { //글쓰기 처리
    		//UI+로직
    		action = new MemoAddService();
    		forward = action.execute(request, response);
    		System.out.println("MemoAddService 실행");
    		
    	}else if(url_Command.equals("/MemoList.memo")) { //목록보기
    		//UI+로직
    		action = new MemoListService();
    		forward = action.execute(request, response);
    		System.out.println("MemoListService 실행");
    		
    	}else if(url_Command.equals("/MemoId.memo")) { //비동기(ID 사용 유무)
    		//UI+로직
    		action = new MemoIdCheckService();
    		forward = action.execute(request, response);
    		System.out.println("MemoIdCheckService 실행");
    		
    	}else if(url_Command.equals("/MemoView.memo")) { //만약 있다면 상세보기
    		//UI 제공 ...
    		//예) /WEB-INF/views/memoview.jsp 가정
    		action = new MemoViewService();
    		forward = action.execute(request, response);
    		System.out.println("MemoViewService 실행");
    		
    	}else if(url_Command.equals("/MemoUpdate.memo")) { 
			//UI 제공 ...
			action = new MemoUpdateService();
			forward = action.execute(request, response);
			System.out.println("MemoUpdateService 실행");
		}else if(url_Command.equals("/MemoUpdateRun.memo")) { 
			//UI 제공 ...
			action = new MemoUpdateRunService();
			forward = action.execute(request, response);
			System.out.println("MemoUpdateService 실행");
		
    	
		}else if(url_Command.equals("/MemoDelete.memo")) { 
			//UI 제공 ...
			action = new MemoDeleteService();
			forward = action.execute(request, response);
			System.out.println("MemoDeleteService 실행");
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
