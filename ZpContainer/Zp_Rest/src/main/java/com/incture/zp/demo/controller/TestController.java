package com.incture.zp.demo.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.delfi.dto.ResponseDto;

@RestController
@ComponentScan("com.incture.zp.demo")
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseDto getMaterialDetails() {
		ResponseDto dto = new ResponseDto();
		dto.setMessage("hello world");
		return dto;
	}

}
