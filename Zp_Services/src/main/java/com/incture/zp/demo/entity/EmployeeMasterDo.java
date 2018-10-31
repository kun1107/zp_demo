package com.incture.zp.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data // for auto generation of getters and setters
@Table(name = "EMPLOYEE_MASTER")
public class EmployeeMasterDo implements BaseDo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "EMP_ID")
	private String employeeId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "EMP_ID")
	private String password;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name = "EMP_TYPE")
	private String employeeType;
	
	@Column(name = "DIVISION")
	private String division;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "POSITION")
	private String position;
	
	@Column(name = "DIVISION")
	private String contactNo;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "BUSINESS_UNIT")
	private String businessUnit;

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return employeeId;
	}

}
