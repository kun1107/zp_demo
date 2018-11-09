package com.incture.zp.demo.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@Getter
@Setter
@ToString
public class BrandPromotionReporttDto {
	private List<ExpenseDetailsDto> listOfExpense;
	private List<TravelDto> listOfTravels;
}
