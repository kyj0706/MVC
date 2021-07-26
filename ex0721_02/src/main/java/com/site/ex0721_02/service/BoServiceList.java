package com.site.ex0721_02.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0721_02.Vo.BoVo;
import com.site.ex0721_02.Dao.BoDao;

public class BoServiceList implements Boservice {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		//전체리스트 가지고 오기
		BoDao boDao = new BoDao();
		ArrayList<BoVo> list = boDao.boAllList();
		request.setAttribute("list", list);

	}

}
