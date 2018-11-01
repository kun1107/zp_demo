package com.incture.zp.demo.entity;

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
@Table(name = "COUNTRY_PRODUCT_MASTER")
public class CountryProductMasterDo implements BaseDo {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PRODUCT_GROUP_CODE")
	private String productGroupCode;
	
	@Column(name = "PRODUCT_GROUP_NAME")
	private String productGroupName;
	
	@Column(name = "PRODUCT_SKU_CODE")
	private String productSkuCode;
	
	@Column(name = "PRODUCT_SKU_NAME")
	private String productSkuName;
	
	@Column(name = "COST_CENTER")
	private String costCenter;
	
	@Column(name = "PRINCIPAL")
	private String principal;
	
	@Column(name = "PRINCIPAL_CODE")
	private String principalCode;
	
	@Column(name = "SAP_CODE")
	private String sapCode;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return productGroupCode;
	}
	
}
