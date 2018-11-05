package com.incture.zp.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data // for auto generation of getters and setters
@Table(name = "LINE_ITEM_REL")
public class LineItemRelDo implements BaseDo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "REL_ID")
	private String relId;
	
	@Column(name = "PARENT_ID")
	private String parentId;
	
	@Column(name = "EXPENSE_LINE_ITEM_ID")
	private String lineItemId;
	
	
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return relId;
	}

}
