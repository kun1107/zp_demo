package com.incture.zp.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.zp.demo.dao.TravelDao;
import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.dto.TravelDto;

@Service("TravelService")
@Transactional
public class TravelService implements TravelServiceLocal{

	@Autowired
	private TravelDao dao;
	
	private ResponseDto responseDto;
	
	@Override
	public ResponseDto createTravel(TravelDto dto){
		responseDto = new ResponseDto();
		try {
			dao.createTravel(dto);
			responseDto.setCode(200);
			responseDto.setStatus(true);
			responseDto.setMessage("Succcess");

		} catch (Exception e) {
			responseDto.setCode(500);
			responseDto.setStatus(false);
			responseDto.setMessage("failed due to: " + e.getMessage());
		}
		return responseDto;
	}
	
	@Override
	public ResponseDto deleteTravel(String travelId){
		responseDto = new ResponseDto();
		try {
			dao.deleteTravel(travelId);
			responseDto.setCode(200);
			responseDto.setStatus(true);
			responseDto.setMessage("Succcess");

		} catch (Exception e) {
			responseDto.setCode(500);
			responseDto.setStatus(false);
			responseDto.setMessage("failed due to: " + e.getMessage());
		}
		return responseDto;
	}
	
	
	@Override
	public ResponseDto getTravelById(String travelId){
		responseDto = new ResponseDto();
		try {
			responseDto.setData(dao.getTravelById(travelId));;
			responseDto.setCode(200);
			responseDto.setStatus(true);
			responseDto.setMessage("Succcess");

		} catch (Exception e) {
			responseDto.setCode(500);
			responseDto.setStatus(false);
			responseDto.setMessage("failed due to: " + e.getMessage());
		}
		return responseDto;
	}
}

