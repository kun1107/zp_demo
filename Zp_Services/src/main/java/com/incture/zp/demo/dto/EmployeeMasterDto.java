package com.incture.zp.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeMasterDto extends BaseDto {
	
	private String employeeId;

	private String userName;

	private String password;

	private String firstName;

	private String lastName;
	
	private String emailAddress;

	private String employeeType;
	
	private String division;

	private String department;

	private String position;
	
	private String contactNo;
	
	private String country;
	
	private String businessUnit;

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return employeeId;
	}

}
