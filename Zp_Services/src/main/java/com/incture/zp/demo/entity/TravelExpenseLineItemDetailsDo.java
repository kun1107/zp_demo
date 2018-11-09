package com.incture.zp.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data // for auto generation of getters and setters
@Table(name = "TRAVEL_EXPENSE_LINE_ITEM_DETAILS")
public class TravelExpenseLineItemDetailsDo implements BaseDo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "EXPENSE_LINE_ITEM_ID")
	private String expenseLineItemId;
	
	@Column(name = "EXPENSE_TYPE")
	private String expenseType;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "TRANSACTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@Column(name = "BUSINESS_PURPOSE")
	private String businessPurpose;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "AMOUNT_CURRENCY")
	private String amountCurrency;
	
	@Column(name = "TAX")
	private BigDecimal tax;
	
	@Column(name = "TAX_CURRENCY")
	private String taxCurrency;
	
	@Column(name = "VENDOR")
	private String vendor;
	
	@Column(name = "VENDOR_ADDRESS")
	private String vendorAddress;
	
	@Column(name = "VENDOR_TIN")
	private String vendorTin;
	
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	
	@Column(name = "COST_CENTRE_NAME")
	private String costCentreName;
	
	@Column(name = "APPROVED_AMOUNT")
	private BigDecimal approvedAmount;
	
	@Column(name = "APPROVED_AMOUNT_CURRENCY")
	private String approvedAmountCurrency;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,orphanRemoval = true,mappedBy = "travelExpenseLineItemDetailsDo")
	private List<TravelExpenseAttendeesDo> listOfAttendees;
	
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return expenseLineItemId;
	}

}
