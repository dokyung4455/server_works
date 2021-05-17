package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.SetSupport;

import com.callor.diet.config.DBContract;
import com.callor.diet.config.DBInfo;
import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService {

	protected Connection dbConn;

	public MyFoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}

	public List<MyFoodCDTO> select(PreparedStatement pStr) throws SQLException {
		List<MyFoodCDTO> mfList = new ArrayList<MyFoodCDTO>();

		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {
			MyFoodCDTO dto = new MyFoodCDTO();

			dto.setMf_seq(rSet.getLong(DBInfo.섭취정보계산.mf_seq));
			dto.setMf_date(rSet.getString(DBInfo.섭취정보계산.mf_date)); // = "섭취일자";
			dto.setMf_fcode(rSet.getString(DBInfo.섭취정보계산.mf_fcode)); // = "식품코드";
			dto.setMf_fname(rSet.getString(DBInfo.섭취정보계산.mf_fname)); // = "식품명";
			dto.setMf_qty(rSet.getFloat(DBInfo.섭취정보계산.mf_qty)); // = "섭취량";
			dto.setMf_once(rSet.getFloat(DBInfo.섭취정보계산.mf_one)); // = "제공량";
			dto.setMf_gram(rSet.getFloat(DBInfo.섭취정보계산.mf_gram)); // = "총내용량";
			dto.setMf_kcal(rSet.getFloat(DBInfo.섭취정보계산.mf_kcal)); // = "에너지";
			dto.setMf_prot(rSet.getFloat(DBInfo.섭취정보계산.mf_prot)); // = "단백질";
			dto.setMf_fat(rSet.getFloat(DBInfo.섭취정보계산.mf_fat)); // = "지방";
			dto.setMf_carbo(rSet.getFloat(DBInfo.섭취정보계산.mf_carbo)); // = "탄수화물";
			dto.setMf_sacc(rSet.getFloat(DBInfo.섭취정보계산.mf_sacc)); // = "총당류";
			mfList.add(dto);
		}
		return mfList;
	}

	@Override
	public List<MyFoodCDTO> selectAll() {
		// TODO 전체식품섭취리스트
		String sql = " SELECT * FROM view_섭취량계산 ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodCDTO> myList = this.select(pStr);
			pStr.close();
			return myList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MyFoodCDTO findById(Long seq) {
		// TODO Auto-generated method stub
String sql = " SELECT * FROM view_섭취량계산 ";
sql += " WHERE 일련번호 = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			List<MyFoodCDTO> myList = this.select(pStr);
			pStr.close();
			if(myList != null && myList.size() > 0) {
				return myList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public MyFoodCDTO findByName(String mf_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodCDTO> findByDate(String mf_date) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_섭취량계산 ";
		sql += " WHERE 일련번호 = ? ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, mf_date);
			List<MyFoodCDTO> myList = this.select(pStr);
			pStr.close();
			return myList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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