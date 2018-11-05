package com.incture.zp.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExpenseDetailsDto extends BaseDto {

	private String expenseDetailId;
	private String employeeId;
	private String claimName;
	private Date claimDate;
	private String costCenterName;
	private String department;
	private String comments;
	private String approvalComment;
	private String approvalStatus;
	private String pendingWith;
	private String additionalInfo;
	
	@Override
	public Object getPrimaryKey() {
		return expenseDetailId;
	}
}