package vn.csc.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.csc.webapp.serviceImpl.ClassDetailServiceImpl;
import vn.csc.webapp.serviceImpl.ClassServiceImpl;
import vn.csc.webapp.serviceImpl.StudentServiceImpl;
import vn.csc.webapp.serviceImpl.UserServiceImpl;
import vn.csc.webapp.services.ClassDetailService;
import vn.csc.webapp.services.ClassService;
import vn.csc.webapp.services.StudentService;
import vn.csc.webapp.services.UserService;

@Configuration
public class BeanConfig {

	@Bean
	public StudentService studentService() {
		StudentService service = new StudentServiceImpl();
		return service;
	}

	@Bean
	public UserService userService() {
		UserService service = new UserServiceImpl();
		return service;
	}

	@Bean
	public ClassDetailService classDetailService() {
		ClassDetailService service = new ClassDetailServiceImpl();
		return service;
	}
	
	@Bean
	public ClassService classService() {
		ClassService service = new ClassServiceImpl();
		return service;
	}
}
