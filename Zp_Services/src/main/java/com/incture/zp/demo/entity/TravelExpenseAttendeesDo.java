package com.incture.zp.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data // for auto generation of getters and setters
@Table(name = "TRAVEL_EXPENSE_ATTENDEES")
public class TravelExpenseAttendeesDo implements BaseDo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ATTENDEES_ID")
	private Long attendeesId;
	
	@Column(name = "ATTENDEE_TYPE")
	private String attendeeType;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ATTENDEE_TITLE")
	private String attendeeTitle;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXPENSE_LINE_ITEM_ID", nullable = false, updatable = false)
	private TravelExpenseLineItemDetailsDo travelExpenseLineItemDetailsDo;
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return attendeesId;
	}

}
