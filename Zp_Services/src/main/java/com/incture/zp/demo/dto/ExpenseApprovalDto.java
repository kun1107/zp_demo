package com.incture.zp.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@Getter
@Setter
@ToString
public class ExpenseApprovalDto {
	private String approverComment;
	private String approvedBy;
	private boolean approved;
	private String expenseDetailId; 
}
