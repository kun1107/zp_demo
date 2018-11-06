package com.incture.zp.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "EXPENSE_DETAILS")
public class ExpenseDetailsDo implements BaseDo{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "EXPENSE_DETAIL_ID")
	private String expenseDetailId;
	
	@Column(name = "TRAVEL_ID")
	private String travelId;
	
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;
	
	@Column(name = "CLAIM_NAME")
	private String claimName;
	
	@Column(name = "CLAIM_DATE")
	private Date claimDate;
	
	@Column(name = "COST_CENTER_NAME")
	private String costCenterName;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "APPROVER_COMMENT")
	private String approvalComment;
	
	@Column(name = "APPROVAL_STATUS")
	private String approvalStatus;
	
	@Column(name = "PENDING_WITH")
	private String pendingWith;
	
	@Column(name = "ADDITIONAL_INFORMATION")
	private String additionalInfo;

	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Override
	public Object getPrimaryKey() {
		return expenseDetailId;
	}
}
