package com.incture.zp.demo.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.incture.zp.demo.dao.EmployeeMasterDao;

public class TestFile {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		applicationContext.getBean(EmployeeMasterDao.class);
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
