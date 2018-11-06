package com.incture.zp.demo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExpenseDetailsDto extends BaseDto {

	private String expenseDetailId;
	private String travelId;
	private String employeeId;
	private String claimName;
	private Date claimDate;
	private String costCenterName;
	private String department;
	private String comments;
	private BigDecimal amount;
	private String approvalComment;
	private String approvalStatus;
	private String pendingWith;
	private String additionalInfo;	
	private String lastApprover;
	private List<String> listOfLineItemId;
	
	@Override
	public Object getPrimaryKey() {
		return expenseDetailId;
	}
}
