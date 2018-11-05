package com.incture.zp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.service.ExpenseDetailsServiceLocal;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/expense", produces = "application/json")
public class ExpenseDetailsRestController {

	@Autowired
	private ExpenseDetailsServiceLocal service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseDto createExpense(@RequestBody ExpenseDetailsDto dto) {
		return service.createExpenseDetail(dto);
	}
	
	@RequestMapping(value="/getExpenseDetailByEmpId/{empId}", method = RequestMethod.GET)
	public ResponseDto getExpenseDetailByEmpId(@PathVariable("empId") String employeeId) {
		return service.getExpenseDetailByEmpId(employeeId);
	}
	
	@RequestMapping(value="/getExpenseDetailByExpenseId/{expId}", method = RequestMethod.GET)
	public ResponseDto getExpenseDetailByExpenseId(@PathVariable("expId") String expenseDetailId) {
		return service.getExpenseDetailByExpenseId(expenseDetailId);
	}
}
