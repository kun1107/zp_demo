package com.incture.zp.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.EmployeeMasterDto;
import com.incture.zp.demo.entity.EmployeeMasterDo;

@Repository("EmployeeMasterDao")
public class EmployeeMasterDao extends BaseDao<EmployeeMasterDo, EmployeeMasterDto> implements EmployeeMasterDaoLocal{

	private EmployeeMasterDo entity;
	
	private List<EmployeeMasterDto> listOfDto;
	
	@Override
	public EmployeeMasterDo importDto(EmployeeMasterDto dto) {
		// TODO Auto-generated method stub
		entity = new EmployeeMasterDo();
		
		entity.setBusinessUnit(dto.getBusinessUnit());
		entity.setContactNo(dto.getContactNo());
		entity.setCountry(dto.getCountry());
		entity.setDepartment(dto.getDepartment());
		entity.setDivision(dto.getDivision());
		entity.setEmailAddress(dto.getEmailAddress());
		entity.setEmployeeId(dto.getEmployeeId());
		entity.setEmployeeType(dto.getEmployeeType());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPassword(dto.getPassword());
		entity.setPosition(dto.getPosition());
		entity.setUserName(dto.getUserName());
		
		return entity;
	}

	@Override
	public EmployeeMasterDto exportDto(EmployeeMasterDo entity) {
		EmployeeMasterDto dto = new EmployeeMasterDto();
		
		dto.setBusinessUnit(entity.getBusinessUnit());
		dto.setContactNo(entity.getContactNo());
		dto.setCountry(entity.getCountry());
		dto.setDepartment(entity.getDepartment());
		dto.setDivision(entity.getDivision());
		dto.setEmailAddress(entity.getEmailAddress());
		dto.setEmployeeId(entity.getEmployeeId());
		dto.setEmployeeType(entity.getEmployeeType());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setPassword(entity.getPassword());
		dto.setPosition(entity.getPosition());
		dto.setUserName(entity.getUserName());
		
		return dto;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeMasterDto> getAllEmployeeDetails(){
		listOfDto = new ArrayList<>();
		
		Query q = getSession().createQuery("from EmployeeMasterDo ");
		
		List<EmployeeMasterDo> listDo = q.list();
		
		for (EmployeeMasterDo employeeMasterDo : listDo) {
			listOfDto.add(exportDto(employeeMasterDo));
		}
		
		return listOfDto;
	}

}
