package com.site.ex0721.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0721.Vo.BVo;
import com.site.ex0721.dao.BDao;

public class BoardServiceList implements BoardService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		BDao bDao = new BDao();
		//게시판 전체리스트 가져오기
		ArrayList<BVo> list = bDao.boardAllList();
		request.setAttribute("list", list);
		
	}

}
