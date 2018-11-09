package com.incture.zp.demo.dao;

import java.util.Date;
import java.util.List;

import com.incture.zp.demo.dto.BrandPromotionReporttDto;
import com.incture.zp.demo.dto.ExpenseApprovalDto;
import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.entity.ExpenseDetailsDo;

public interface ExpenseDetailsDaoLocal {

	ExpenseDetailsDo importDto(ExpenseDetailsDto dto);

	ExpenseDetailsDto exportDto(ExpenseDetailsDo entity);

	ExpenseDetailsDto getExpenseDetailByExpenseId(String expenseDetailId);

	List<ExpenseDetailsDto> getExpenseDetailByEmpId(String employeeId);

	String createExpenseDetail(ExpenseDetailsDto dto);

	String expenseApproval(ExpenseApprovalDto dto);

	List<ExpenseDetailsDto> getPendingApprovals(String pendingWith);

	List<ExpenseDetailsDto> getCostCentreStats(String costCenterName, Date startDate, Date endDate);

	List<BrandPromotionReporttDto> getBrandPromotionReport(String brandName, Date startDate, Date endDate);

}
