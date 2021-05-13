package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.SetSupport;

import com.callor.diet.config.DBContract;
import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService {

	protected Connection dbConn;

	public MyFoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}

	@Override
	public List<MyFoodCDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodCDTO findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodCDTO findByName(String mf_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodCDTO findByDate(String mf_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_myfoods( ";
			sql += "mf_seq,";
			sql += "mf_code,";
			sql += "mf_date,";
			sql += "mf_qty) ";
			sql += " VALUES(seq_myfoods.NEXTVAL, ?, ?, ?) ";
			
			PreparedStatement pStr = null;
			try {
				pStr = dbConn.prepareStatement(sql);
				pStr.setString(1, myFoodVO.getMf_code());
				pStr.setString(2, myFoodVO.getMf_date());
				pStr.setString(3, myFoodVO.getMf_qty());
				
				Integer result = pStr.executeUpdate();
				pStr.close();
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public Integer update(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}
}