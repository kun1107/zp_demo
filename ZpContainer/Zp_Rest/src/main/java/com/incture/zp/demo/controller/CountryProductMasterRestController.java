package com.incture.zp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.service.CountryProductMasterServiceLocal;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/countryProduct", produces = "application/json")
public class CountryProductMasterRestController {

	@Autowired
	private CountryProductMasterServiceLocal service;
	
	@RequestMapping(value = "/getAllCountryProductDetails", method = RequestMethod.GET)
	public ResponseDto getAllCountryProductDetails() {
		return service.getAllCountryProductDetails();
	}
}
