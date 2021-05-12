package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FoodVO {
	
	private String fd_code; //	char(7 byte)
	private String fd_name; //	nvarchar2(200 char)
	private Integer fd_date; //	char(4 byte)
	private String fd_ccode; //	char(6 byte)
	private String fd_icode; //	char(4 byte)
	private Float fd_one; // number
	private Float fd_gram; // number
	private Float fd_kcal; // number
	private Float fd_prot; // number
	private Float fd_fat; // number
	private Float fd_carbo; // number
	private Float fd_sacc; // number

}
