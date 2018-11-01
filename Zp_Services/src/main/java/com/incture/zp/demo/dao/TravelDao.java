package com.incture.zp.demo.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

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
	public void createTravel(TravelDto dto){
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String travelId = sequenceNumberGen.getNextSeqNumber("T", 10, getSession());
		dto.setTravelId(travelId);
		
		//should be replaced by workflow
		dto.setApprovalStatus("Pending");
		dto.setPendingWith("Approver1");
		
		getSession().persist(importDto(dto));
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
}
