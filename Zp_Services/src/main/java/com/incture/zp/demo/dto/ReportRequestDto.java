package com.incture.zp.demo.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@Getter
@Setter
@ToString
public class ReportRequestDto {

	private String costCenterName;
	private Date startDate;
	private Date endDate;
}
