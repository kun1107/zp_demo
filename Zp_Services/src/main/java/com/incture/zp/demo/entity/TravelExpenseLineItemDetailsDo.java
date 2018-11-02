package com.incture.zp.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TravelExpenseLineItemDetailsDo implements BaseDo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long expenseLineItemId;
	
	private String expenseType;
	
	private String department;
	
	private Date transactionDate;
	
	private String businessPurpose;
	
	private BigDecimal amount;
	
	private String amountCurrency;
	
	private BigDecimal tax;
	
	private String taxCurrency;
	
	private String vendor;
	
	private String vendorAddress;
	
	private String vendorTin;
	
	private String paymentType;
	
	private String costCentreName;
	
	private BigDecimal approvedAmount;
	
	private String comments;
	
	private List<TravelExpenseAttendeesDo> listOfAttendees;
	
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return expenseLineItemId;
	}

}
