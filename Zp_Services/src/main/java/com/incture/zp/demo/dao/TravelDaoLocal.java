package com.incture.zp.demo.dao;

import java.util.Date;
import java.util.List;

import com.incture.zp.demo.dto.ApprovalDto;
import com.incture.zp.demo.dto.TravelDto;

public interface TravelDaoLocal {

	String createTravel(TravelDto dto);

	void deleteTravel(String travelId);

	TravelDto getTravelById(String travelId);

	List<TravelDto> getTravelByEmpId(String empId);

	List<TravelDto> getPendingApproval(String empId);

	String approval(ApprovalDto dto);

	List<TravelDto> getApprovedTravels(String empId);

	List<TravelDto> getTravelsByBrandName(String brandName, Date startDate, Date endDate);

}
