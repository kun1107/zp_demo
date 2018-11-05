package com.incture.zp.demo.service;

import javax.jws.Oneway;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.zp.demo.dao.ExpenseDetailsDaoLocal;
import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.dto.ResponseDto;

@Service("ExpenseDetailsService")
@Transactional
public class ExpenseDetailsService implements ExpenseDetailsServiceLocal{

	@Autowired
	private ExpenseDetailsDaoLocal dao;
	
	private ResponseDto responseDto;
	
	@Override
	public ResponseDto createExpenseDetail(ExpenseDetailsDto dto){
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.createExpenseDetail(dto));
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
