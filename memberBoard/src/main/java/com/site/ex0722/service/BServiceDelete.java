package com.site.ex0722.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0722.dao.BDao;
import com.site.ex0722.vo.BVo;

public class BServiceDelete implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		
		//하단넘버링 관련정보
		int page=1; //현재페이지
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		//board 1개 삭제 - int
		int result = bDao.boardDelete(bid);
		request.setAttribute("result", result);
		request.setAttribute("bid", bid);
		request.setAttribute("page", page);

	}

}
