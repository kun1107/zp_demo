package com.incture.zp.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.service.ExpenseDetailsServiceLocal;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/report", produces = "application/json")
public class ReportRestController {

	@Autowired
	private ExpenseDetailsServiceLocal service;

	@RequestMapping(value = "/getCostCentreStats/{costCenterName}/{startDate}/{endDate}", method = RequestMethod.GET)
	public ResponseDto getCostCentreStats(@PathVariable("costCenterName") String costCenterName,
			@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) {
		return service.getCostCentreStats(costCenterName,startDate,endDate);
	}
}
