package com.site.ex0721;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.bo")
public class BoardController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher =null;
		
		//페이지 분기
		String uri = request.getRequestURI();
		String cpath =request.getContextPath();
		String fname =uri.substring(cpath.length());
		
		if(fname.equals("/login.do")) {
			//출력할거야  () 여기에 있는걸
			System.out.println("호출페이지 : "+fname);
			System.out.println("login.jsp페이지로 호출만");
			
			
		}else if(fname.equals("/member.do")) {
			System.out.println("호출페이지 : "+fname);
			System.out.println("member.jsp페이지로 호출만");
			
		}else if(fname.equals("/logout.do")) {
			System.out.println("호출페이지 : "+fname);
			System.out.println("logout.jsp페이지로 호출만");
			
		}else if(fname.equals("/list.do")) {
			System.out.println("호출페이지 : "+fname);
			BService service = new BServiceList();
			service.excute(request, response);
			dispatcher = request.getRequestDispatcher("./list.jsp");
			System.out.println("controller");
			//response.sendRedirect("/login.jsp");
			//board.jsp로 requst를 전달해 줄거입니다 .
			//Dispatcher내용을 담아서 보낼거입니다.
			
		}else if(fname.equals("/member_modify.do")) {
			System.out.println("호출페이지 : "+fname);
			System.out.println("DB접근해서 1명의 회원정보테이터 가지고오기");
			System.out.println("member_modify.jsp페이지로 데이터 전달해서 호출함");
		}
		
		dispatcher.forward(request, response);
		
		/*
		 * response.setContentType("text/html; charset=utf-8"); PrintWriter writer =
		 * response.getWriter(); writer.println("<html><head></head><body>");
		 * writer.println("<h3>확장자패텅 작업</h>");
		 * writer.println("<h3>uri이다 : "+uri+" 서버 이름이 없다.</h>");
		 * writer.println("<h3>cpath이다 : "+cpath+" 프로젝트명을 출력해준다</h>");
		 * writer.println("<h3>fname이다 : "+fname+" 프로젝트명을 제외한 글을 출력해준다 </h>");
		 * writer.println("</body></html>"); writer.close();
		 */
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
			
	}

}
