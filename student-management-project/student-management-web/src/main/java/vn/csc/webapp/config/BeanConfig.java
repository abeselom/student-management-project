package vn.csc.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.csc.webapp.serviceImpl.StudentServiceImpl;
import vn.csc.webapp.services.StudentService;

@Configuration
public class BeanConfig {
	
	@Bean 
	public StudentService studentService() {
		StudentService service = new StudentServiceImpl();
		return service;
	}
}
