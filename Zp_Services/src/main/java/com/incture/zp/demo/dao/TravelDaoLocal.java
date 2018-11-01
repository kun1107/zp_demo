package com.incture.zp.demo.dao;

import com.incture.zp.demo.dto.TravelDto;

public interface TravelDaoLocal {

	void createTravel(TravelDto dto);

	void deleteTravel(String travelId);

	TravelDto getTravelById(String travelId);

}
