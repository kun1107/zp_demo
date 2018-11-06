package com.incture.zp.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.ExpenseApprovalDto;
import com.incture.zp.demo.dto.ExpenseDetailsDto;
import com.incture.zp.demo.dto.TravelDto;
import com.incture.zp.demo.entity.ExpenseDetailsDo;
import com.incture.zp.demo.entity.LineItemRelDo;
import com.incture.zp.demo.util.SequenceNumberGen;

@Repository("ExpenseDetailsDao")
public class ExpenseDetailsDao extends BaseDao<ExpenseDetailsDo, ExpenseDetailsDto> implements ExpenseDetailsDaoLocal{

	private ExpenseDetailsDo entity;
	private ExpenseDetailsDto dto;
	
	private LineItemRelDo relEntity;
	
	private TravelDto travel;
	
	@Autowired
	private LineItemRelDaoLocal relDao;
	
	@Autowired
	private TravelDaoLocal travelDao;
	
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
		entity.setAmount(dto.getAmount());
		entity.setLastApprover(dto.getLastApprover());
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
		dto.setAmount(entity.getAmount());
		dto.setLastApprover(entity.getLastApprover());
		return dto;
	}
	
	@Override
	public String createExpenseDetail(ExpenseDetailsDto dto){
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String expenseDetailId = sequenceNumberGen.getNextSeqNumber("E", 10, getSession());
		dto.setExpenseDetailId(expenseDetailId);
		
		
		for ( String lineItemId : dto.getListOfLineItemId()) {
			relEntity = new LineItemRelDo();
			
			relEntity.setParentId(expenseDetailId);
			relEntity.setLineItemId(lineItemId);;
			
			relDao.createRelation(relEntity);
		}
		
		if(dto.getTravelId()!=null && !dto.getTravelId().isEmpty()){
			travel = travelDao.getTravelById(dto.getTravelId());
			if(travel!=null && travel.getCashAdvanceAmount().compareTo(dto.getAmount())!=0){
				dto.setApprovalStatus("Pending");
				dto.setPendingWith("APL8553");
			}else{
				dto.setLastApprover("System");
				dto.setApprovalComment("Auto-Approved");
				dto.setPendingWith(null);
				dto.setApprovalStatus("Approved");
			}
		}else{
			dto.setApprovalStatus("Pending");
			dto.setPendingWith("APL8553");
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

	@Override
	public String expenseApproval(ExpenseApprovalDto dto) {
		
		return "Success";
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ExpenseDetailsDto> getPendingApprovals(String pendingWith) {
		List<ExpenseDetailsDto> detailsDtos = new ArrayList<>();
		List<ExpenseDetailsDo> detailsDos;
		String query = "from ExpenseDetailsDo e where e.pendingWith=:pendingWith";
		Query q = getSession().createQuery(query);
		q.setParameter("pendingWith", pendingWith);
		detailsDos = q.list();
		for(ExpenseDetailsDo entity : detailsDos){
			detailsDtos.add(exportDto(entity));
		}
		return detailsDtos;
	}
	
}
