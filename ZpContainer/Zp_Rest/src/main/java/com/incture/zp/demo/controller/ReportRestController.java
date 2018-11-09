package com.incture.zp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.zp.demo.dto.ReportRequestDto;
import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.service.ExpenseDetailsServiceLocal;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/report", produces = "application/json")
public class ReportRestController {

	@Autowired
	private ExpenseDetailsServiceLocal service;

	@RequestMapping(value = "/costCentreReports", method = RequestMethod.POST)
	public ResponseDto getCostCentreStats(@RequestBody ReportRequestDto dto) {
		return service.getCostCentreStats(dto.getCostCenterName(),dto.getStartDate(),dto.getEndDate());
	}
	
	@RequestMapping(value = "/brandPromotionReport", method = RequestMethod.POST)
	public ResponseDto brandPromotionReport(@RequestBody ReportRequestDto dto) {
		return service.getBrandPromotionReport(dto.getBrandName(),dto.getStartDate(),dto.getEndDate());
	}
	
}
