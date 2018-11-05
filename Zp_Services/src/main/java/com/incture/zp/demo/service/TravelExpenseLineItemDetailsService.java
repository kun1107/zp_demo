package com.incture.zp.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.zp.demo.dao.TravelExpenseLineItemDetailsDaoLocal;
import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;

@Service("TravelExpenseLineItemDetailsService")
@Transactional
public class TravelExpenseLineItemDetailsService implements TravelExpenseLineItemDetailsServiceLocal{

	@Autowired
	private TravelExpenseLineItemDetailsDaoLocal dao;

	
	private ResponseDto responseDto;
	

	@Override
	public ResponseDto createLineItem(TravelExpenseLineItemDetailsDto dto){
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.createLineItem(dto));
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


	@Override
	public ResponseDto getExpenseLineItem(String expenseLineItemId) {
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.getExpenseLineItem(expenseLineItemId));
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
