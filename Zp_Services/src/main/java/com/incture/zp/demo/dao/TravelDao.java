package com.incture.zp.demo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.ApprovalDto;
import com.incture.zp.demo.dto.TravelDto;
import com.incture.zp.demo.entity.LineItemRelDo;
import com.incture.zp.demo.entity.TravelDo;
import com.incture.zp.demo.util.SequenceNumberGen;

@Repository("TravelDao")
public class TravelDao extends BaseDao<TravelDo, TravelDto> implements TravelDaoLocal {

	private TravelDo entity;
	private TravelDto dto;
	
	private LineItemRelDo relEntity;
	
	@Autowired
	private LineItemRelDaoLocal relDao;

	private SequenceNumberGen sequenceNumberGen;

	private BigDecimal maxEstimatedValue = new BigDecimal("20000.0");

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
		entity.setEstimatedCost(dto.getEstimatedCost());
		entity.setEstimatedCostCurrency(dto.getEstimatedCostCurrency());
		entity.setProjectName(dto.getProjectName());
		entity.setSkuCode(dto.getSkuCode());

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
		dto.setEstimatedCost(entity.getEstimatedCost());
		dto.setEstimatedCostCurrency(entity.getEstimatedCostCurrency());
		dto.setProjectName(entity.getProjectName());
		dto.setSkuCode(entity.getSkuCode());

		return dto;
	}

	@Override
	public String createTravel(TravelDto dto) {
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String travelId = sequenceNumberGen.getNextSeqNumber("TR"+sequenceNumberGen.getString()+"-", 4, getSession());
		dto.setTravelId(travelId);

		// should be replaced by workflow
		dto.setApprovalStatus("Pending");
		dto.setPendingWith("APL8553");

		
		
		//
		
		for ( String lineItemId : dto.getListOfLineItemId()) {
			relEntity = new LineItemRelDo();
			
			relEntity.setParentId(travelId);
			relEntity.setLineItemId(lineItemId);
			
			relDao.createRelation(relEntity);
		}
		getSession().saveOrUpdate(importDto(dto));

		return travelId;
	}

	@Override
	public void deleteTravel(String travelId) {
		dto = new TravelDto();
		dto.setTravelId(travelId);
		getSession().delete(importDto(dto));
	}

	@Override
	public TravelDto getTravelById(String travelId) {
		String query = "from TravelDo t where t.travelId=:travelId";
		Query q = getSession().createQuery(query);

		q.setParameter("travelId", travelId);

		dto = exportDto((TravelDo) q.uniqueResult());
		dto.setListOfLineItemDto(relDao.getListOfLineItems(travelId));
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TravelDto> getTravelByEmpId(String empId) {
		List<TravelDto> travelDtoList = new ArrayList<>();
		List<TravelDo> travelDoList;
		String query = "from TravelDo t where t.employeeId=:empId";
		Query q = getSession().createQuery(query);
		q.setParameter("empId", empId);
		travelDoList = q.list();
		for (TravelDo t : travelDoList) {
			dto = exportDto(t);
			dto.setListOfLineItemDto(relDao.getListOfLineItems(t.getTravelId()));
			travelDtoList.add(dto);
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
		for (TravelDo t : travelDoList) {
			dto = exportDto(t);
			dto.setListOfLineItemDto(relDao.getListOfLineItems(t.getTravelId()));
			travelDtoList.add(dto);
		}
		return travelDtoList;
	}

	@Override
	public String approval(ApprovalDto dto) {
		String query = "from TravelDo t where t.travelId =:travelId";
		Query q = getSession().createQuery(query);
		q.setParameter("travelId", dto.getTravelId());

		entity = (TravelDo) q.uniqueResult();

		if (dto.isApproved() && entity.getEstimatedCost().compareTo(maxEstimatedValue) == 1) {
			if (dto.getApprovedBy().equals("APL8553")) {
				entity.setLastApprover(dto.getApprovedBy());
				entity.setApproverComment(dto.getApproverComment());
				entity.setPendingWith("8978");
				entity.setApprovalStatus("Pending");
			} else if (dto.getApprovedBy().equals("8978")) {
				entity.setLastApprover(dto.getApprovedBy());
				entity.setApproverComment(dto.getApproverComment());
				entity.setPendingWith("99098");
				entity.setApprovalStatus("Pending");
			} else {
				entity.setLastApprover(dto.getApprovedBy());
				entity.setApproverComment(dto.getApproverComment());
				entity.setPendingWith(null);
				entity.setApprovalStatus("Approved");
			}
		} else if (dto.isApproved() && entity.getEstimatedCost().compareTo(maxEstimatedValue) <= 0) {
			entity.setLastApprover(dto.getApprovedBy());
			entity.setApproverComment(dto.getApproverComment());
			entity.setPendingWith(null);
			entity.setApprovalStatus("Approved");
		} else {
			entity.setLastApprover(dto.getApprovedBy());
			entity.setApproverComment(dto.getApproverComment());
			entity.setPendingWith(null);
			entity.setApprovalStatus("Rejected");
		}

		getSession().update(entity);

		return "successfully updated";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TravelDto> getApprovedTravels(String empId){
		List<TravelDto> travelDtoList = new ArrayList<>();
		List<TravelDo> travelDoList;
		String query = "from TravelDo t where t.employeeId=:empId and t.approvalStatus = 'Approved'";
		Query q = getSession().createQuery(query);
		q.setParameter("empId", empId);
		travelDoList = q.list();
		for (TravelDo t : travelDoList) {
			dto = exportDto(t);
			dto.setListOfLineItemDto(relDao.getListOfLineItems(t.getTravelId()));
			travelDtoList.add(dto);
		}
		return travelDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TravelDto> getTravelsByBrandName(String brandName, Date startDate, Date endDate) {
		List<TravelDto> travelDtoList = new ArrayList<>();
		List<TravelDo> travelDoList;
		String query = "from TravelDo t where t.projectName=:brandName and t.startDate >= :startDate and t.startDate <= :endDate";
		Query q = getSession().createQuery(query);
		q.setParameter("brandName", brandName);
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		
		travelDoList = q.list();
		for (TravelDo t : travelDoList) {
			dto = exportDto(t);
			dto.setListOfLineItemDto(relDao.getListOfLineItems(t.getTravelId()));
			travelDtoList.add(dto);
		}
		return travelDtoList;
	}
}
