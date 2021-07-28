package com.site.ex0722.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0722.dao.BDao;
import com.site.ex0722.vo.BVo;

public class BServiceView implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		//하단넘버링 관련정보
		int page=1; //현재페이지
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String category = request.getParameter("category");
		String s_word = request.getParameter("s_word");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		//board 1개 리스트 가져오기 - BVo
		BVo bVo = bDao.boardOneSelect(bid);
		request.setAttribute("bVo", bVo);
		request.setAttribute("page", page);
		request.setAttribute("category", category);
		request.setAttribute("s_word", s_word);

	}

}
