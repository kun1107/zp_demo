package com.incture.zp.demo.service;

import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.dto.ResponseDto;

public interface ExpenseDetailsServiceLocal {

	ResponseDto createExpenseDetail(ExpenseDetailsDto dto);

}
