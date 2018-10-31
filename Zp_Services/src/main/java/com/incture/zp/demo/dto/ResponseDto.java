package com.incture.zp.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@Getter
@Setter
@ToString
public class ResponseDto {
	private int code;
	private boolean status;
	private String message;
	Object data;
}
