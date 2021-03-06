package com.incture.zp.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.TravelExpenseAttendeesDto;
import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;
import com.incture.zp.demo.entity.TravelExpenseAttendeesDo;
import com.incture.zp.demo.entity.TravelExpenseLineItemDetailsDo;
import com.incture.zp.demo.util.SequenceNumberGen;

@Repository("TravelExpenseLineItemDetailsDao")
public class TravelExpenseLineItemDetailsDao extends BaseDao<TravelExpenseLineItemDetailsDo, TravelExpenseLineItemDetailsDto> implements TravelExpenseLineItemDetailsDaoLocal{

	private TravelExpenseLineItemDetailsDto dto;
	private TravelExpenseLineItemDetailsDo entity;
	

	private SequenceNumberGen sequenceNumberGen;
	
	@Override
	public TravelExpenseLineItemDetailsDo importDto(TravelExpenseLineItemDetailsDto dto){
		entity = new TravelExpenseLineItemDetailsDo();
		
		entity.setExpenseLineItemId(dto.getExpenseLineItemId());
		entity.setAmount(dto.getAmount());
		entity.setAmountCurrency(dto.getAmountCurrency());
		entity.setApprovedAmount(dto.getApprovedAmount());
		entity.setApprovedAmountCurrency(dto.getApprovedAmountCurrency());
		entity.setBusinessPurpose(dto.getBusinessPurpose());
		entity.setComments(dto.getComments());
		entity.setCostCentreName(dto.getCostCentreName());
		entity.setDepartment(dto.getDepartment());
		entity.setExpenseType(dto.getExpenseType());
		entity.setPaymentType(dto.getPaymentType());
		entity.setTax(dto.getTax());
		entity.setTaxCurrency(dto.getTaxCurrency());
		entity.setTransactionDate(dto.getTransactionDate());
		entity.setVendor(dto.getVendor());
		entity.setVendorAddress(dto.getVendorAddress());
		entity.setVendorTin(dto.getVendorTin());
		
		List<TravelExpenseAttendeesDo> listOfAttendees = new ArrayList<>();
		TravelExpenseAttendeesDo attendeesDo;
		for(TravelExpenseAttendeesDto attendeesDto : dto.getListOfAttendees()){
			attendeesDo = new TravelExpenseAttendeesDo();
			
			attendeesDo.setAttendeesId(attendeesDto.getAttendeesId());
			attendeesDo.setAttendeeTitle(attendeesDto.getAttendeeTitle());
			attendeesDo.setAttendeeType(attendeesDto.getAttendeeType());
			attendeesDo.setDate(attendeesDto.getDate());
			attendeesDo.setDepartment(attendeesDto.getDepartment());
			attendeesDo.setName(attendeesDto.getName());
			attendeesDo.setAmount(dto.getAmount());
			attendeesDo.setTravelExpenseLineItemDetailsDo(entity);
			
			listOfAttendees.add(attendeesDo);
		}
		
		entity.setListOfAttendees(listOfAttendees);
		return entity;
	}
	
	@Override
	public TravelExpenseLineItemDetailsDto exportDto(TravelExpenseLineItemDetailsDo entity){
		dto = new TravelExpenseLineItemDetailsDto();
		
		dto.setAmount(entity.getAmount());
		dto.setAmountCurrency(entity.getAmountCurrency());
		dto.setApprovedAmount(entity.getApprovedAmount());
		dto.setApprovedAmountCurrency(entity.getApprovedAmountCurrency());
		dto.setBusinessPurpose(entity.getBusinessPurpose());
		dto.setComments(entity.getComments());
		dto.setCostCentreName(entity.getCostCentreName());
		dto.setDepartment(entity.getDepartment());
		dto.setExpenseLineItemId(entity.getExpenseLineItemId());
		dto.setExpenseType(entity.getExpenseType());
		dto.setPaymentType(entity.getPaymentType());
		dto.setTax(entity.getTax());
		dto.setTaxCurrency(entity.getTaxCurrency());
		dto.setTransactionDate(entity.getTransactionDate());
		dto.setVendor(entity.getVendor());
		dto.setVendorAddress(entity.getVendorAddress());
		dto.setVendorTin(entity.getVendorTin());
		
		List<TravelExpenseAttendeesDto> attendeesDtolist = new ArrayList<>();
		TravelExpenseAttendeesDto attendeesDto;
		for(TravelExpenseAttendeesDo attendeesDo : entity.getListOfAttendees()){
			attendeesDto = new TravelExpenseAttendeesDto();
			
			attendeesDto.setAttendeesId(attendeesDo.getAttendeesId());
			attendeesDto.setAttendeeTitle(attendeesDo.getAttendeeTitle());
			attendeesDto.setAttendeeType(attendeesDo.getAttendeeType());
			attendeesDto.setDate(attendeesDo.getDate());
			attendeesDto.setDepartment(attendeesDo.getDepartment());
			attendeesDto.setName(attendeesDo.getName());
			attendeesDto.setAmount(attendeesDo.getAmount());
			
			attendeesDtolist.add(attendeesDto);
		}
		
		dto.setListOfAttendees(attendeesDtolist);
		return dto;
	}
	
	@Override
	public String createLineItem(TravelExpenseLineItemDetailsDto dto){
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String expenseLineItemId = sequenceNumberGen.getNextSeqNumber("L", 10, getSession());
		dto.setExpenseLineItemId(expenseLineItemId);
		
		for (TravelExpenseAttendeesDto attendeesDto : dto.getListOfAttendees()) {
			attendeesDto.setAttendeesId(sequenceNumberGen.getNextSeqNumber("A", 10, getSession()));
		}
		getSession().persist(importDto(dto));
		return expenseLineItemId;
	}

	@Override
	public TravelExpenseLineItemDetailsDto getExpenseLineItem(String expenseLineItemId) {
		String query = "from TravelExpenseLineItemDetailsDo t where t.expenseLineItemId=:expenseLineItemId";
		Query q = getSession().createQuery(query);

		q.setParameter("expenseLineItemId", expenseLineItemId);

		entity = (TravelExpenseLineItemDetailsDo) q.uniqueResult();
		
		if(entity!=null)
		dto = exportDto(entity);

		return dto;
	}
	
	@Override
	public void deleteExpenseLineItem(String expenseLineItemId) {
		TravelExpenseLineItemDetailsDo entity = (TravelExpenseLineItemDetailsDo) getSession().get(TravelExpenseLineItemDetailsDo.class, expenseLineItemId);
		getSession().delete(entity);
		
		String query = "delete from LineItemRelDo l where l.lineItemId=:lineItemId";
		Query q = getSession().createQuery(query);
		q.setParameter("lineItemId", expenseLineItemId);
		q.executeUpdate();		
	}
	
	@Override
	public String updateLineItem(TravelExpenseLineItemDetailsDto dto){
		String expenseLineItemId = dto.getExpenseLineItemId();
		getSession().update(importDto(dto));
		return expenseLineItemId;
	}
}
