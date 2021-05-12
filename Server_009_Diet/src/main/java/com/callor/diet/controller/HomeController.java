package com.callor.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReqController.forward(req, resp, "home");
		// req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);// (/) 프로젝트를 런하면 home.jsp를 보여달라
	}
	
	

}
