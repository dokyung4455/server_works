package com.callor.guest.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.guest.model.GuestBookVO;
import com.callor.guest.service.GuestBookService;
import com.callor.guest.service.impl.GuestbookServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{
	
	protected GuestBookService gbService;
	public HomeController() {
		gbService = new GuestbookServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<GuestBookVO> gbList = gbService.selectAll();
		req.setAttribute("GBLIST", gbList);
		
		
		req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
		
		
	}
	
	

}
