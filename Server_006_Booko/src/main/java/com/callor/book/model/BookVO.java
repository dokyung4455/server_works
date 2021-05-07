package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
	
	private String BK_ISBN;//CHAR(13 BYTE)
	private String BK_TITLE;//NVARCHAR2(125 CHAR)
	private String BK_CCODE;//CHAR(5 BYTE)
	private String BK_ACODE;//CHAR(5 BYTE)
	private String BK_DATE;//CHAR(10 BYTE)
	private Integer BK_PRICE;//NUMBER
	private Integer BK_PAGES;//	NUMBER

}
