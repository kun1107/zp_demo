package com.incture.zp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.service.EmployeeMasterServiceLocal;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/employeeMaster", produces = "application/json")
public class EmployeeMasterRestController {

	@Autowired
	private EmployeeMasterServiceLocal service;
	
	@RequestMapping(value = "/getAllEmployeeDetails", method = RequestMethod.GET)
	public ResponseDto getAllEmployeeDetails() {
		return service.getAllEmployeeDetails();
	}

}
