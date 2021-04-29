package com.callor.db.service;

import java.util.List;

import com.callor.db.model.BookVO;

/*
 * 업무적인 분석이 없이 만드는 DB 프로젝트에서는 필수적으로 필요한 method가 있다.
 * 
 * DB와 연동되는 프로젝트는 1ㅂ개의 table마다 서비슥 ㅏ만들어지는데 CRUD를 최소한 구현해야 한다.
 */
public interface BookService {
	
	 //WEEB Browser에서 데이터를 보내면 Controller에서 데이터를 받고 Service 클래스에 데이터를 전달하여 DB에 insert를 수행한다.
	public void insert(BookVO bookVO); // CREATE : 데이터추가
	
	// Web에서 데이터를 보여달라는 요청이 있으면 Controller에서 Service의 select() method를 호출할 것이며
	// select() method는 DB로부터 데이터를 읽어서 Controller에게 return 한다.
	public List<BookVO> selectAll(); // READ : 데이터조회
	
	// Controller로 부터 PK칼럼(bk_isbn)에 해당하는 값 1개를 전달받고 
	// PK 칼럼에 조건을 부여하여 select한 후 데이터를 return하는 method
	public BookVO findeById(String bk_isbn);
	
	// 도서명 검색 = 도서명을 전달받아 해당 도서명의 모든 데이터를 return
	public List<BookVO> FindeByTitle(String bk_title);
	//출판사코드
	public List<BookVO> FindeByComp(String bk_comp);
	//외 저자코드, 발행일, 가격 등으로 검색
	
	// 변경하고자 하는 데이터를 전달받아서(전달받은 데이터에는 반드시 PK값이 포함되어 있어야 한다.) PK로 조건을 설정하고 데이터를 UPDATE
	public void update(BookVO bookVO); // UPDATE : 데이터변경(갱신,수정)
	
	// 삭제하고자 하는 데이터의 PK값을 매개변수로 전달받고 1개의 데이터를 삭제한다.
	public void delete(String bk_isbn); // DELETE : 데이터삭제
	
	

}
