package com.incture.zp.demo.service;

import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;

public interface TravelExpenseLineItemDetailsServiceLocal {

	ResponseDto createLineItem(TravelExpenseLineItemDetailsDto dto);

	ResponseDto getExpenseLineItem(String expenseLineItemId);

}
