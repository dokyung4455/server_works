package com.callor.diet.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.FoodService;
import com.callor.diet.service.MyFoodService;
import com.callor.diet.service.impl.FoodServiceImplV1;
import com.callor.diet.service.impl.MyFoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet {
	
	protected FoodService fdService;
	protected MyFoodService mfService;
	public FoodController() {
		// TODO Auto-generated constructor stub
		fdService = new FoodServiceImplV1();
		mfService = new MyFoodServiceImplV1();
	}

	
	
	// anchor link를 클릭했을때 처리할 method
	// a tag : <a href>
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청주소에 /food/* 의 *에 오는 요청을 추출함
		// food/search로 요청이오면 /search를 추출한다.
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath 없음");
		} else if(subPath.equals("/search")) { // 식품검색시 보여주기 구현
			ReqController.forward(req, resp, "search");
			
		} else if(subPath.equals("/insert")) {
			// 식품을 선택하여 식품코드를 전달받은 후 섭취정보를 입력하기 위한 화면을 보여주기
			// 전달받은 식품코드로 식품정보를 조회하여 insert.jsp에 전달하기
			String fd_code = req.getParameter("fd_code"); // inser.jsp에서 mf_code로 지정된값 받아서 fd_code 변수에 담기
			
			FoodDTO fdDTO = fdService.findById(fd_code);
			req.setAttribute("FOOD", fdDTO);
			
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			String today = sd.format(date);
			req.setAttribute("TODAY", today);
			
			ReqController.forward(req, resp, "insert");
			
		}
		
		
	}
	
	// form에서 input Box에 입력한 데이터를 전송했을때 method를 POST로 지정하면 처리할 method
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		
		if(subPath == null || subPath.equals("")) {
			System.out.println("요청 subPath가 없음");
		} else if(subPath.equals("/search")) {
			// form에 입력된 데이터를 추출(parameter를 Get)하고 DB에 조회하여 다시 Web에 보여주기
			String f_name = req.getParameter("f_name"); //search.jsp 에서 f_name 가져오기
			List<FoodDTO> foodList = fdService.findByFName(f_name);
			
			req.setAttribute("FOODS", foodList); // foodList를 search에서 FOODS라는 이름으로 items에 보내자
			
			ReqController.forward(req, resp, "search");
			
			
		} else if(subPath.equals("/insert")) {
			System.out.println("insert 전달 완료");
			String strFcode = req.getParameter("mf_code");
			String strDate = req.getParameter("mf_date");
			String strQty = req.getParameter("mf_qty");
			
			MyFoodVO myFoodVO = new MyFoodVO();
			myFoodVO.setMf_code(strFcode);
			myFoodVO.setMf_date(strDate);
			myFoodVO.setMf_qty(strQty);
			
			int result = mfService.insert(myFoodVO);
			if(result > 0) {
				System.out.println("추가 성공");
				resp.sendRedirect("/diet/");
			} else {
				System.out.println("추가 실패");
			}
			
			
		}
		
	}
	
	

}
