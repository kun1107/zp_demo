package com.incture.zp.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TravelDto extends BaseDto {

	private String travelId;

	private String requestPolicy;
	
	private String employeeId;

	private String costCentreCode;

	private String costCentreName;

	private String department;

	private String tripDescription;

	private Date startDate;

	private Date endDate;

	private String country;

	private String city;

	private String tripPurpose;

	private String travellerType;

	private String additionalInformation;

	private boolean cashAdvanceNeeded;

	private BigDecimal cashAdvanceAmount;

	private String cashAdvanceCurrency;

	private boolean corporateCreditCardNeeded;

	private BigDecimal corporateCreditCardAmount;

	private String corporateCreditCardCurrency;

	private String cashAdvanceComment;

	private String approvalStatus;

	private String pendingWith;

	private String lastApprover;

	private String approverComment;

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return travelId;
	}

}
