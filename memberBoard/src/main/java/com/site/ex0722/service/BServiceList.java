package com.site.ex0722.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0722.dao.BDao;
import com.site.ex0722.vo.BVo;

public class BServiceList implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		//총 게시글수,총검색 게시글수 - int
		String category = request.getParameter("category");
		if(request.getParameter("s_word")==null) category="";
		String s_word = request.getParameter("s_word");
		int listCount = bDao.boardCountSelect(category,s_word);
		System.out.println("service category : "+category);
		
		
		//하단넘버링 관련정보
		int page=1; //현재페이지
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit=10; //리스트 게시글수 10,15,20개...
		int maxPage=(int)((double)listCount/limit+0.99);
		int startPage = ((int)((double)page/limit+0.99)-1)*limit+1;
		int endPage = startPage+10-1;
		if(endPage>maxPage) endPage=maxPage;
		
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("category", category);
		request.setAttribute("s_word", s_word);
		
		
		//가지고 올 10개 데이터 범위
		int startrow = (page-1)*limit+1;
		int endrow = startrow+limit-1;
		
		//board 10개 리스트 가져오기 - ArrayList
		ArrayList<BVo> list = bDao.boardAllSelect(startrow,endrow,category,s_word);
		request.setAttribute("list", list);

	
	}

}
