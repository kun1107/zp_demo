package com.incture.zp.demo.entity;

import java.util.Date;

public class TravelExpenseAttendeesDo implements BaseDo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long attendeesId;
	
	private String attendeeType;
	
	private String name;
	
	private String attendeeTitle;
	
	private String department;
	
	private Date date;

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return attendeesId;
	}

}
