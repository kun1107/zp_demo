package com.incture.zp.demo.dao;

import com.incture.zp.demo.dto.TravelExpenseAttendeesDto;
import com.incture.zp.demo.entity.TravelExpenseAttendeesDo;

public interface TravelExpenseAttendeesDaoLocal {

	TravelExpenseAttendeesDo importDto(TravelExpenseAttendeesDto dto);

	TravelExpenseAttendeesDto exportDto(TravelExpenseAttendeesDo entity);

}
