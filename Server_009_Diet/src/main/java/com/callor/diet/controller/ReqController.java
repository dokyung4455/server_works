package com.callor.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqController {
	
	// method가 static이면 객체를 생성하지않고 호출가능하다.
	public static void forward (HttpServletRequest req, HttpServletResponse resp, String file) throws ServletException, IOException {
		
		// search를 매개로 전송하면 /WEB-INF/views/search.jsp 작동
		file = "/WEB-INF/views/" + file + ".jsp";
		
		req.getRequestDispatcher(file).forward(req, resp);
		
		
	}

	
}
