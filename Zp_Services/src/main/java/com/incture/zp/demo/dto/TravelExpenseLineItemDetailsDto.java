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
public class TravelExpenseLineItemDetailsDto extends BaseDto {

	private String expenseLineItemId;

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

	private List<TravelExpenseAttendeesDto> listOfAttendees;

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return expenseLineItemId;
	}

}
