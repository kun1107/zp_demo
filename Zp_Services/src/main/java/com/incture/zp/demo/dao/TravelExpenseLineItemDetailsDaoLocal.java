package com.incture.zp.demo.dao;

import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;
import com.incture.zp.demo.entity.TravelExpenseLineItemDetailsDo;

public interface TravelExpenseLineItemDetailsDaoLocal {

	TravelExpenseLineItemDetailsDo importDto(TravelExpenseLineItemDetailsDto dto);

	TravelExpenseLineItemDetailsDto exportDto(TravelExpenseLineItemDetailsDo entity);

}
