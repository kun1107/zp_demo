package com.incture.zp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;
import com.incture.zp.demo.service.TravelExpenseLineItemDetailsServiceLocal;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/lineItem", produces = "application/json")
public class TravelExpenseLineItemDetailsRestController {

	@Autowired
	private TravelExpenseLineItemDetailsServiceLocal service;
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseDto createTravel(@RequestBody TravelExpenseLineItemDetailsDto dto) {
		return service.createLineItem(dto);
	}

}
