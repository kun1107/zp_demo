package com.incture.zp.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.zp.demo.dao.EmployeeMasterDaoLocal;
import com.incture.zp.demo.dto.ResponseDto;

@Service("EmployeeMasterService")
@Transactional
public class EmployeeMasterService implements EmployeeMasterServiceLocal{
	
	@Autowired
	private EmployeeMasterDaoLocal dao;
	
	private ResponseDto responseDto;
	
	@Override
	public ResponseDto getAllEmployeeDetails(){
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.getAllEmployeeDetails());
			responseDto.setCode(200);
			responseDto.setStatus(true);
			responseDto.setMessage("Succcess");

		} catch (Exception e) {
			responseDto.setCode(500);
			responseDto.setStatus(false);
			responseDto.setMessage("failed due to: " + e.getMessage());
		}
		return responseDto;
	}
	
}
