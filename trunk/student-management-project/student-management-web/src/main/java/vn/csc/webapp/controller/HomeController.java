package vn.csc.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.webapp.services.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> map) {
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		studentDTOList = studentService.getStudentList();
		map.put("studentList", studentDTOList);
		map.put("number", studentService.getNumberOfStudents());
		return "home";
	}
}