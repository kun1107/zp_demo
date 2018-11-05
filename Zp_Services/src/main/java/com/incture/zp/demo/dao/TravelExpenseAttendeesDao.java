package com.incture.zp.demo.dao;

import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.TravelExpenseAttendeesDto;
import com.incture.zp.demo.entity.TravelExpenseAttendeesDo;

@Repository("TravelExpenseAttendeesDao")
public class TravelExpenseAttendeesDao implements TravelExpenseAttendeesDaoLocal{
	
	private TravelExpenseAttendeesDto dto;
	private TravelExpenseAttendeesDo entity;
	
	@Override
	public TravelExpenseAttendeesDo importDto(TravelExpenseAttendeesDto dto){
		entity = new TravelExpenseAttendeesDo();
		
		entity.setAttendeeTitle(dto.getAttendeeTitle());
		entity.setAttendeeType(dto.getAttendeeType());
		entity.setDate(dto.getDate());
		entity.setDepartment(dto.getDepartment());
		entity.setName(dto.getName());
		entity.setAmount(dto.getAmount());
		
		return entity;
	}
	
	@Override
	public TravelExpenseAttendeesDto exportDto(TravelExpenseAttendeesDo entity){
		dto = new TravelExpenseAttendeesDto();
		
		dto.setAttendeesId(entity.getAttendeesId());
		dto.setAttendeeTitle(entity.getAttendeeTitle());
		dto.setAttendeeType(entity.getAttendeeType());
		dto.setDate(entity.getDate());
		dto.setDepartment(entity.getDepartment());
		dto.setName(entity.getName());
		dto.setAmount(entity.getAmount());
		
		return dto;
	}
}
