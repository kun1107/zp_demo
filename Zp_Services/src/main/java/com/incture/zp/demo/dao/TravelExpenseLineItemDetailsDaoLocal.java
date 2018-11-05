package com.incture.zp.demo.dao;

import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;

public interface TravelExpenseLineItemDetailsDaoLocal {

	String createLineItem(TravelExpenseLineItemDetailsDto dto);

	TravelExpenseLineItemDetailsDto getExpenseLineItem(String expenseLineItemId);

}
