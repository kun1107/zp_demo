package com.incture.zp.demo.service;

import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.dto.TravelDto;

public interface TravelServiceLocal {

	ResponseDto createTravel(TravelDto dto);

	ResponseDto deleteTravel(String travelId);

	ResponseDto getTravelById(String travelId);

}
