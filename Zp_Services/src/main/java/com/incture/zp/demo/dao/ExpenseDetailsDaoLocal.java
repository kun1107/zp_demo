package com.incture.zp.demo.dao;

import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.entity.ExpenseDetailsDo;

public interface ExpenseDetailsDaoLocal {

	ExpenseDetailsDo importDto(ExpenseDetailsDto dto);

	ExpenseDetailsDto exportDto(ExpenseDetailsDo entity);

	String createExpenseDetail(ExpenseDetailsDto dto);

}
