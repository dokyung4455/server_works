package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.config.DBinfo;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

// localhost:8080/todo/sub/* 요청받기
@WebServlet("/sub/*")
public class TodoController extends HttpServlet{
	
	protected TodoService tdService;
	public TodoController() {
		tdService = new TodoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strSeq = req.getParameter("seq");
		Long tdSeq = Long.valueOf(strSeq);
		Map<String,Object> tdVO = tdService.findById(tdSeq);
		Object td_edate = tdVO.get(DBinfo.td_edate);
		if(td_edate == null || String.valueOf(td_edate).equals("")) {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			
			String edate = sd.format(date);
			String etime = st.format(date);
			
			tdVO.put(DBinfo.td_edate, edate);
			tdVO.put(DBinfo.td_etime, etime);
		} else {
			tdVO.put(DBinfo.td_edate, null);
			tdVO.put(DBinfo.td_etime, null);
			
		}
		System.out.println(tdVO.toString());
		
		tdService.update(tdVO);
		
		resp.sendRedirect(req.getContextPath());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String td_doit = req.getParameter(DBinfo.td_doit);
		
		// Map type의 VO 선언하기
		Map<String,Object> tdVO = new HashMap<String, Object>();
		tdVO.put(DBinfo.td_doit, td_doit);
		tdService.insert(tdVO);
		
		resp.sendRedirect(req.getContextPath());
		
	}
	
	
	
	
}
