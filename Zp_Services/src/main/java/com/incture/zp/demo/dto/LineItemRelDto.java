package com.incture.zp.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LineItemRelDto extends BaseDto {

	private String relId;
	
	private String parentId;

	private String lineItemId;
	
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
