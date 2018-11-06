package com.incture.zp.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.LineItemRelDto;
import com.incture.zp.demo.dto.TravelExpenseLineItemDetailsDto;
import com.incture.zp.demo.entity.LineItemRelDo;
import com.incture.zp.demo.util.SequenceNumberGen;


@Repository("LineItemRelDao")
public class LineItemRelDao extends BaseDao<LineItemRelDo, LineItemRelDto> implements LineItemRelDaoLocal{

	private LineItemRelDto dto;
	
	private LineItemRelDo entity;
	
	private SequenceNumberGen sequenceNumberGen;
	
	@Autowired
	private TravelExpenseLineItemDetailsDaoLocal lineItemdao;
	
	@Override
	public LineItemRelDo importDto(LineItemRelDto dto) {
		entity = new LineItemRelDo();
		
		entity.setParentId(dto.getParentId());
		entity.setRelId(dto.getRelId());
		
		return entity;
	}

	@Override
	public LineItemRelDto exportDto(LineItemRelDo entity) {
	
		dto = new LineItemRelDto();
		

		dto.setParentId(entity.getParentId());
		dto.setRelId(entity.getRelId());
		
		return dto;
	}

	@Override
	public void createRelation(LineItemRelDo entity){
		sequenceNumberGen = SequenceNumberGen.getInstance();
		String relId = sequenceNumberGen.getNextSeqNumber("R", 15, getSession());
		
		entity.setRelId(relId);
		
		getSession().persist(entity);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getLineItemIds(String id){
		List<String> ids = new ArrayList<>();
		List<LineItemRelDo> relDo = new ArrayList<>();
		String query = "from LineItemRelDo l where l.parentId=:id";
		Query q = getSession().createQuery(query);
		q.setParameter("id", id);
		relDo = q.list();
		for(LineItemRelDo entity : relDo){
			ids.add(entity.getLineItemId());
		}
		return ids;
	}
	
	@Override
	public List<TravelExpenseLineItemDetailsDto> getListOfLineItems(String itemId){
		List<TravelExpenseLineItemDetailsDto> lineItemDetailsDtos = new ArrayList<>();
		List<String> ids = getLineItemIds(itemId);
		TravelExpenseLineItemDetailsDto detailsDto;
		for(String id : ids){
			detailsDto = lineItemdao.getExpenseLineItem(id);
			lineItemDetailsDtos.add(detailsDto);
		}
		return lineItemDetailsDtos;
	}
}
