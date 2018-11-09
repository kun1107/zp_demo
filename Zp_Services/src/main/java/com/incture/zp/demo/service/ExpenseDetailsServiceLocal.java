package com.incture.zp.demo.service;

import java.util.Date;

import com.incture.zp.demo.dto.ExpenseApprovalDto;
import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.dto.ResponseDto;

public interface ExpenseDetailsServiceLocal {

	ResponseDto createExpenseDetail(ExpenseDetailsDto dto);

	ResponseDto getExpenseDetailByEmpId(String employeeId);

	ResponseDto getExpenseDetailByExpenseId(String expenseDetailId);

	ResponseDto expenseApproval(ExpenseApprovalDto dto);

	ResponseDto getPendingApprovals(String pendingWith);

	ResponseDto getCostCentreStats(String costCenterName, Date startDate, Date endDate);

}
