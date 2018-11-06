package com.incture.zp.demo.dao;

import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.LineItemRelDto;
import com.incture.zp.demo.entity.LineItemRelDo;
import com.incture.zp.demo.util.SequenceNumberGen;


@Repository("LineItemRelDao")
public class LineItemRelDao extends BaseDao<LineItemRelDo, LineItemRelDto> implements LineItemRelDaoLocal{

	private LineItemRelDto dto;
	
	private LineItemRelDo entity;
	
	private SequenceNumberGen sequenceNumberGen;
	
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
}
