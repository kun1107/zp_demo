package com.incture.zp.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.ApprovalDto;
import com.incture.zp.demo.dto.TravelDto;
import com.incture.zp.demo.entity.TravelDo;
import com.incture.zp.demo.util.SequenceNumberGen;

@Repository("TravelDao")
public class TravelDao extends BaseDao<TravelDo, TravelDto> implements TravelDaoLocal{

	private TravelDo entity;
	private TravelDto dto;
	
	private SequenceNumberGen sequenceNumberGen;
	
	@Override
	public TravelDo importDto(TravelDto dto) {
		// TODO Auto-generated method stub
		entity = new TravelDo();
		
		entity.setTravelId(dto.getTravelId());
		entity.setEmployeeId(dto.getEmployeeId());
		entity.setAdditionalInformation(dto.getAdditionalInformation());
		entity.setApprovalStatus(dto.getApprovalStatus());
		entity.setApproverComment(dto.getApproverComment());
		entity.setCashAdvanceAmount(dto.getCashAdvanceAmount());
		entity.setCashAdvanceComment(dto.getCashAdvanceComment());
		entity.setCashAdvanceCurrency(dto.getCashAdvanceCurrency());
		entity.setCashAdvanceNeeded(dto.isCashAdvanceNeeded());
		entity.setCity(dto.getCity());
		entity.setCorporateCreditCardAmount(dto.getCorporateCreditCardAmount());
		entity.setCorporateCreditCardCurrency(dto.getCorporateCreditCardCurrency());
		entity.setCorporateCreditCardNeeded(dto.isCorporateCreditCardNeeded());
		entity.setCostCentreCode(dto.getCostCentreCode());
		entity.setCostCentreName(dto.getCostCentreName());
		entity.setCountry(dto.getCountry());
		entity.setDepartment(dto.getDepartment());
		entity.setEndDate(dto.getEndDate());
		entity.setLastApprover(dto.getLastApprover());
		entity.setPendingWith(dto.getPendingWith());
		entity.setRequestPolicy(dto.getRequestPolicy());
		entity.setStartDate(dto.getStartDate());
		entity.setTravellerType(dto.getTravellerType());
		entity.setTripDescription(dto.getTripDescription());
		entity.setTripPurpose(dto.getTripPurpose());
		return entity;
	}

	@Override
	public TravelDto exportDto(TravelDo entity) {
		// TODO Auto-generated method stub
		dto = new TravelDto();
		
		dto.setTravelId(entity.getTravelId());
		dto.setEmployeeId(entity.getEmployeeId());
		dto.setAdditionalInformation(entity.getAdditionalInformation());
		dto.setApprovalStatus(entity.getApprovalStatus());
		dto.setApproverComment(entity.getApproverComment());
		dto.setCashAdvanceAmount(entity.getCashAdvanceAmount());
		dto.setCashAdvanceComment(entity.getCashAdvanceComment());
		dto.setCashAdvanceCurrency(entity.getCashAdvanceCurrency());
		dto.setCashAdvanceNeeded(entity.isCashAdvanceNeeded());
		dto.setCity(entity.getCity());
		dto.setCorporateCreditCardAmount(entity.getCorporateCreditCardAmount());
		dto.setCorporateCreditCardCurrency(entity.getCorporateCreditCardCurrency());
		dto.setCorporateCreditCardNeeded(entity.isCorporateCreditCardNeeded());
		dto.setCostCentreCode(entity.getCostCentreCode());
		dto.setCostCentreName(entity.getCostCentreName());
		dto.setCountry(entity.getCountry());
		dto.setDepartment(entity.getDepartment());
		dto.setEndDate(entity.getEndDate());
		dto.setLastApprover(entity.getLastApprover());
		dto.setPendingWith(entity.getPendingWith());
		dto.setRequestPolicy(entity.getRequestPolicy());
		dto.setStartDate(entity.getStartDate());
		dto.setTravellerType(entity.getTravellerType());
		dto.setTripDescription(entity.getTripDescription());
		dto.setTripPurpose(entity.getTripPurpose());
		
		return dto;
	}

	@Override
	public String createTravel(TravelDto dto){
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String travelId = sequenceNumberGen.getNextSeqNumber("T", 10, getSession());
		dto.setTravelId(travelId);
		
		//should be replaced by workflow
		dto.setApprovalStatus("Pending");
		dto.setPendingWith("Approver1");
		
		getSession().persist(importDto(dto));
		
		return travelId;
	}
	
	@Override
	public void deleteTravel(String travelId){
		dto = new TravelDto();
		dto.setTravelId(travelId);
		getSession().delete(importDto(dto));
	}
	
	@Override
	public TravelDto getTravelById(String travelId){
		String query = "from TravelDo t where t.travelId=:travelId";
		Query q = getSession().createQuery(query);

		q.setParameter("travelId", travelId);
		
		dto = exportDto((TravelDo)q.uniqueResult());
		
		return dto;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TravelDto> getTravelByEmpId(String empId){
		List<TravelDto> travelDtoList = new ArrayList<>();
		List<TravelDo> travelDoList;
		String query = "from TravelDo t where t.employeeId=:empId";
		Query q = getSession().createQuery(query);
		q.setParameter("empId", empId);
		travelDoList = q.list();
		for(TravelDo t : travelDoList){
			travelDtoList.add(exportDto(t));
		}
		return travelDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TravelDto> getPendingApproval(String empId) {
		List<TravelDto> travelDtoList = new ArrayList<>();
		List<TravelDo> travelDoList;
		String query = "from TravelDo t where t.approvalStatus = 'Pending' and t.pendingWith =:empId";
		Query q = getSession().createQuery(query);
		q.setParameter("empId", empId);
		travelDoList = q.list();
		for(TravelDo t : travelDoList){
			travelDtoList.add(exportDto(t));
		}
		return travelDtoList;
	}

	@Override
	public String approval(ApprovalDto dto) {
		String query = "from TravelDo t where t.travelId =: travelId";
		Query q = getSession().createQuery(query);
		q.setParameter("travelId", dto.getTravelId());
		
		entity=(TravelDo)q.uniqueResult();
		
		entity.setLastApprover(dto.getApprovedBy());
		entity.setApproverComment(dto.getApproverComment());
		entity.setPendingWith("Approver2");
		entity.setApprovalStatus("Pending");
		
		getSession().update(entity);
		
		return "successfully updated";
	}
}
