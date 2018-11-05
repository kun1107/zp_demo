package com.incture.zp.demo.dao;

import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.entity.ExpenseDetailsDo;
import com.incture.zp.demo.util.SequenceNumberGen;

@Repository("ExpenseDetailsDao")
public class ExpenseDetailsDao extends BaseDao<ExpenseDetailsDo, ExpenseDetailsDto> implements ExpenseDetailsDaoLocal{

	private ExpenseDetailsDo entity;
	private ExpenseDetailsDto dto;
	
	private SequenceNumberGen sequenceNumberGen;
	
	@Override
	public ExpenseDetailsDo importDto(ExpenseDetailsDto dto){
		entity = new ExpenseDetailsDo();
		
		entity.setExpenseDetailId(dto.getExpenseDetailId());
		entity.setClaimName(dto.getClaimName());
		entity.setClaimDate(dto.getClaimDate());
		entity.setCostCenterName(dto.getCostCenterName());
		entity.setDepartment(dto.getDepartment());
		entity.setComments(dto.getComments());
		entity.setApprovalStatus(dto.getApprovalStatus());
		entity.setPendingWith(dto.getPendingWith());
		entity.setApprovalComment(dto.getApprovalComment());
		entity.setAdditionalInfo(dto.getAdditionalInfo());
		
		return entity;
	}
	
	@Override
	public ExpenseDetailsDto exportDto(ExpenseDetailsDo entity){
		dto = new ExpenseDetailsDto();
		
		dto.setExpenseDetailId(entity.getExpenseDetailId());
		dto.setClaimName(entity.getClaimName());
		dto.setClaimDate(entity.getClaimDate());
		dto.setCostCenterName(entity.getCostCenterName());
		dto.setDepartment(entity.getDepartment());
		dto.setComments(entity.getComments());
		dto.setApprovalStatus(entity.getApprovalStatus());
		dto.setPendingWith(entity.getPendingWith());
		dto.setAdditionalInfo(entity.getAdditionalInfo());
		dto.setApprovalComment(entity.getApprovalComment());
		
		return dto;
	}
	
	@Override
	public String createExpenseDetail(ExpenseDetailsDto dto){
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String expenseDetailId = sequenceNumberGen.getNextSeqNumber("E", 10, getSession());
		dto.setExpenseDetailId(expenseDetailId);
		getSession().persist(importDto(dto));
		return expenseDetailId;
	}
}
