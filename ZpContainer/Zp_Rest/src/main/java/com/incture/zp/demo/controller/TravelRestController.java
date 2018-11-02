package com.incture.zp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.zp.demo.dto.ApprovalDto;
import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.dto.TravelDto;
import com.incture.zp.demo.service.TravelServiceLocal;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/travel", produces = "application/json")
public class TravelRestController {
	
	@Autowired
	private TravelServiceLocal service;
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseDto getAllEmployeeDetails(@RequestBody TravelDto dto) {
		return service.createTravel(dto);
	}

	@RequestMapping(value="/{travelId}", method = RequestMethod.DELETE)
	public ResponseDto getAllEmployeeDetails(@PathVariable("travelId") String travelId) {
		return service.deleteTravel(travelId);
	}
	
	@RequestMapping(value="/{travelId}", method = RequestMethod.GET)
	public ResponseDto getTravelById(@PathVariable("travelId") String travelId) {
		return service.getTravelById(travelId);
	}
	
	@RequestMapping(value="/getTravelByEmpId/{empId}", method = RequestMethod.GET)
	public ResponseDto getTravelByEmpId(@PathVariable("empId") String empId) {
		return service.getTravelByEmpId(empId);
	}
	
	@RequestMapping(value="/getPendingApproval/{empId}", method = RequestMethod.GET)
	public ResponseDto getPendingApproval(@PathVariable("empId") String empId) {
		return service.getPendingApproval(empId);
	}
	
	@RequestMapping(value="/approval", method = RequestMethod.POST)
	public ResponseDto approval(@RequestBody ApprovalDto dto) {
		return service.approval(dto);
	}

}
