package com.incture.zp.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.entity.ExpenseDetailsDo;
import com.incture.zp.demo.entity.LineItemRelDo;
import com.incture.zp.demo.util.SequenceNumberGen;

@Repository("ExpenseDetailsDao")
public class ExpenseDetailsDao extends BaseDao<ExpenseDetailsDo, ExpenseDetailsDto> implements ExpenseDetailsDaoLocal{

	private ExpenseDetailsDo entity;
	private ExpenseDetailsDto dto;
	
	private LineItemRelDo relEntity;
	
	@Autowired
	private LineItemRelDaoLocal relDao;
	
	private SequenceNumberGen sequenceNumberGen;
	
	@Override
	public ExpenseDetailsDo importDto(ExpenseDetailsDto dto){
		entity = new ExpenseDetailsDo();
		
		entity.setExpenseDetailId(dto.getExpenseDetailId());
		entity.setEmployeeId(dto.getEmployeeId());
		entity.setClaimName(dto.getClaimName());
		entity.setClaimDate(dto.getClaimDate());
		entity.setCostCenterName(dto.getCostCenterName());
		entity.setDepartment(dto.getDepartment());
		entity.setComments(dto.getComments());
		entity.setApprovalStatus(dto.getApprovalStatus());
		entity.setPendingWith(dto.getPendingWith());
		entity.setApprovalComment(dto.getApprovalComment());
		entity.setAdditionalInfo(dto.getAdditionalInfo());
		entity.setTravelId(dto.getTravelId());
		return entity;
	}
	
	@Override
	public ExpenseDetailsDto exportDto(ExpenseDetailsDo entity){
		dto = new ExpenseDetailsDto();
		
		dto.setExpenseDetailId(entity.getExpenseDetailId());
		dto.setEmployeeId(entity.getEmployeeId());
		dto.setClaimName(entity.getClaimName());
		dto.setClaimDate(entity.getClaimDate());
		dto.setCostCenterName(entity.getCostCenterName());
		dto.setDepartment(entity.getDepartment());
		dto.setComments(entity.getComments());
		dto.setApprovalStatus(entity.getApprovalStatus());
		dto.setPendingWith(entity.getPendingWith());
		dto.setAdditionalInfo(entity.getAdditionalInfo());
		dto.setApprovalComment(entity.getApprovalComment());
		dto.setTravelId(entity.getTravelId());
		
		return dto;
	}
	
	@Override
	public String createExpenseDetail(ExpenseDetailsDto dto){
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String expenseDetailId = sequenceNumberGen.getNextSeqNumber("E", 10, getSession());
		dto.setExpenseDetailId(expenseDetailId);
		
		
		for ( String relId : dto.getListOfLineItemId()) {
			relEntity = new LineItemRelDo();
			
			relEntity.setParentId(expenseDetailId);
			relEntity.setRelId(relId);
			
			relDao.createRelation(relEntity);
		}
		
		getSession().persist(importDto(dto));
		return expenseDetailId;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExpenseDetailsDto> getExpenseDetailByEmpId(String employeeId){
		List<ExpenseDetailsDto> detailsDtos = new ArrayList<>();
		List<ExpenseDetailsDo> detailsDos;
		String query = "from ExpenseDetailsDo e where e.employeeId=:employeeId";
		Query q = getSession().createQuery(query);
		q.setParameter("employeeId", employeeId);
		detailsDos = q.list();
		for(ExpenseDetailsDo entity : detailsDos){
			detailsDtos.add(exportDto(entity));
		}
		return detailsDtos;
	}
	
	@Override
	public ExpenseDetailsDto getExpenseDetailByExpenseId(String expenseDetailId){
		String query = "from ExpenseDetailsDo e where e.expenseDetailId=:expenseDetailId";
		Query q = getSession().createQuery(query);
		q.setParameter("expenseDetailId", expenseDetailId);
		dto = exportDto((ExpenseDetailsDo) q.uniqueResult());
		return dto;
	}
}
