package com.incture.zp.demo.service;

import com.incture.zp.demo.dto.ApprovalDto;
import com.incture.zp.demo.dto.ResponseDto;
import com.incture.zp.demo.dto.TravelDto;

public interface TravelServiceLocal {

	ResponseDto createTravel(TravelDto dto);

	ResponseDto deleteTravel(String travelId);

	ResponseDto getTravelById(String travelId);

	ResponseDto getTravelByEmpId(String empId);

	ResponseDto getPendingApproval(String empId);

	ResponseDto approval(ApprovalDto dto);

}
