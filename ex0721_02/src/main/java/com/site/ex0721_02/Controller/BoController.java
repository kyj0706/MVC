package com.site.ex0721_02.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0721_02.service.BoServiceList;
import com.site.ex0721_02.service.Boservice;


@WebServlet("*.do")
public class BoController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = null;
		
		String uri = request.getRequestURI();
		System.out.println(request.getContextPath());
		String filePath =uri.substring(request.getContextPath().length());
		
		if(filePath.equals("/board/bolist.do")) {
			Boservice boservice =new BoServiceList();
			boservice.excute(request, response);
			dispatcher = request.getRequestDispatcher("./bolist.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	
	//------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request,response);
	}

}
