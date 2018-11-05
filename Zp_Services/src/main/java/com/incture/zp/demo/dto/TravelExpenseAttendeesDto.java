package com.incture.zp.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TravelExpenseAttendeesDto extends BaseDto{

	private String attendeesId;
	
	private String attendeeType;
	
	private String name;
	
	private String attendeeTitle;
	
	private String department;
	
	private Date date;
	
	private BigDecimal amount;

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return attendeesId;
	}
}
