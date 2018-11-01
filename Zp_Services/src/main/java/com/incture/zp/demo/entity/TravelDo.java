package com.incture.zp.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data // for auto generation of getters and setters
@Table(name = "TRAVEL")
public class TravelDo implements BaseDo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "TRAVEL_ID")
	private String travelId;
	
	@Column(name = "REQUEST_POLICY")
	private String requestPolicy;
	
	@Column(name = "EMP_ID")
	private String employeeId;
	
	@Column(name = "COST_CENTRE_CODE")
	private String costCentreCode;
	
	@Column(name = "COST_CENTRE_NAME")
	private String costCentreName;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "TRIP_DESCRIPTION")
	private String tripDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	private Date endDate;
	
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "TRIP_PURPOSE")
	private String tripPurpose;
	
	@Column(name = "TRAVELLER_TYPE")
	private String travellerType;
	
	@Column(name = "ADDITIONAL_INFORMATION")
	private String additionalInformation;
	
	@Column(name = "CASH_ADVANCE_NEEDED")
	private boolean cashAdvanceNeeded;
	
	@Column(name = "CASH_ADVANCE_AMOUNT")
	private BigDecimal cashAdvanceAmount;
	
	@Column(name = "CASH_ADVANCE_CURRENCY")
	private String cashAdvanceCurrency;
	
	@Column(name = "CORPORATE_CREDIT_CARD_NEEDED")
	private boolean corporateCreditCardNeeded;
	
	@Column(name = "CORPORATE_CREDIT_CARD_AMOUNT")
	private BigDecimal corporateCreditCardAmount;
	
	@Column(name = "CORPORATE_CREDIT_CARD_CURRENCY")
	private String corporateCreditCardCurrency;
	
	@Column(name = "CASH_ADVANCE_COMMENT")
	private String cashAdvanceComment;

	@Column(name = "APPROVAL_STATUS")
	private String approvalStatus;
	
	@Column(name = "PENDING_WITH")
	private String pendingWith;
	
	@Column(name = "LAST_APPROVER")
	private String lastApprover;
	
	@Column(name = "APPROVER_COMMENT")
	private String approverComment;

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return travelId;
	}

}
