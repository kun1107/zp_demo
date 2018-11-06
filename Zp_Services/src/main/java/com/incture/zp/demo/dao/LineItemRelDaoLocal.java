package com.incture.zp.demo.dao;

import java.util.List;

import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;
import com.incture.zp.demo.entity.LineItemRelDo;

public interface LineItemRelDaoLocal {

	void createRelation(LineItemRelDo entity);

	List<String> getLineItemIds(String id);

	List<TravelExpenseLineItemDetailsDto> getListOfLineItems(String itemId);

}
