package com.incture.zp.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.zp.demo.dao.ExpenseDetailsDaoLocal;
import com.incture.zp.demo.dto.ExpenseApprovalDto;
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
	
	@Override
	public ResponseDto getExpenseDetailByEmpId(String employeeId){
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.getExpenseDetailByEmpId(employeeId));
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
	public ResponseDto getExpenseDetailByExpenseId(String expenseDetailId){
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.getExpenseDetailByExpenseId(expenseDetailId));
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
	public ResponseDto expenseApproval(ExpenseApprovalDto dto) {
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.expenseApproval(dto));
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
	public ResponseDto getPendingApprovals(String pendingWith) {
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.getPendingApprovals(pendingWith));
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
