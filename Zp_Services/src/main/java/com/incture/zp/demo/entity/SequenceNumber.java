package com.incture.zp.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "T_SEQ_NUMBER")
@NamedQuery(name = "SequenceNumber.getAll", query = "SELECT seq FROM SequenceNumber seq")
public class SequenceNumber {

	@Id
	@Column(name = "REFERENCE_CODE")
	private String referenceCode;

	@Column(name = "RUNNING_NUMBER")
	private Integer runningNumber;

	public SequenceNumber() {

	}

	public SequenceNumber(String referenceCode, Integer runningNumber) {
		this.referenceCode = referenceCode;
		this.runningNumber = runningNumber;
	}
}

