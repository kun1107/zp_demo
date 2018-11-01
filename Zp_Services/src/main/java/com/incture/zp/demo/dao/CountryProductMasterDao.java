package com.incture.zp.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.CountryProductMasterDto;
import com.incture.zp.demo.entity.CountryProductMasterDo;

@Repository("CountryProductMasterDao")
public class CountryProductMasterDao extends BaseDao<CountryProductMasterDo, CountryProductMasterDto> implements CountryProductMasterDaoLocal{

	private CountryProductMasterDo entity;
	
	private List<CountryProductMasterDto> listOfDto;
	
	@Override
	public CountryProductMasterDo importDto(CountryProductMasterDto dto){
		entity = new CountryProductMasterDo();
		
		entity.setProductGroupCode(dto.getProductGroupCode());
		entity.setProductGroupName(dto.getProductGroupName());
		entity.setProductSkuCode(dto.getProductSkuCode());
		entity.setProductSkuName(dto.getProductSkuName());
		entity.setCostCenter(dto.getCostCenter());
		entity.setPrincipalCode(dto.getPrincipalCode());
		entity.setPrincipal(dto.getPrincipal());
		entity.setSapCode(dto.getSapCode());
		entity.setStartDate(dto.getStartDate());
		
		return entity;
	}
	
	@Override
	public CountryProductMasterDto exportDto(CountryProductMasterDo entity){
		CountryProductMasterDto dto = new CountryProductMasterDto();
		
		dto.setProductGroupCode(entity.getProductGroupCode());
		dto.setProductGroupName(entity.getProductGroupName());
		dto.setProductSkuCode(entity.getProductSkuCode());
		dto.setProductSkuName(entity.getProductSkuName());
		dto.setPrincipalCode(entity.getPrincipalCode());
		dto.setPrincipal(entity.getPrincipal());
		dto.setCostCenter(entity.getCostCenter());
		dto.setSapCode(entity.getSapCode());
		dto.setStartDate(entity.getStartDate());
		
		return dto;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CountryProductMasterDto> getAllCountryProductDetails(){
		listOfDto = new ArrayList<>();
		Query q = getSession().createQuery("from CountryProductMasterDo ");
		List<CountryProductMasterDo> listDo = q.list();
		for(CountryProductMasterDo entity : listDo){
			listOfDto.add(exportDto(entity));
		}
		return listOfDto;
	}
	
}
