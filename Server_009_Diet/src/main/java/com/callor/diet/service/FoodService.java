package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.FoodVO;

public interface FoodService {
	// CRUD를 구현할 method 정의 << 설계
	public List<FoodDTO> selectAll(); // 데이터 조회(read)
	public FoodDTO findById(String fd_code); // Primary key로 조회하는 method
	public List<FoodDTO> findByFName(String fd_name); // 이름으로 조회
	
	public Integer insert(FoodVO foodVO); // 데이터 변환(추가)
	public Integer update(FoodVO foodVO); // 데이터 변환(수정)
	public Integer delete(String fd_code); // 데이터 변환(삭제
	

}
