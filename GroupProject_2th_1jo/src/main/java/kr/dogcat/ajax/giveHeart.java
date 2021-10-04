package kr.dogcat.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.dogcat.dao.PboardDao;

//@WebServlet("/giveHeart")
public class giveHeart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public giveHeart() {
        super();
    }
	
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("giveHeart왔니?");
		
		String rec_email= request.getParameter("rec_email");
		int board_num= Integer.parseInt(request.getParameter("pbnum"));
		
		try {
			
			PrintWriter out = response.getWriter();
			
			
			PboardDao dao = new PboardDao();
			int result = dao.giveHeart(board_num,rec_email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
		
		
		
	
    	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
