package com.incture.zp.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CountryProductMasterDto extends BaseDto {

	private String productGroupCode;
	
	private String productGroupName;
	
	private String productSkuCode;
	
	private String productSkuName;
	
	private String costCenter;
	
	private String principal;
	
	private String principalCode;
	
	private String sapCode;
	
	private Date startDate;
	
	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return productGroupCode;
	}
}
