package vn.csc.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.csc.finalproject.dto.ClazzDTO;
import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.webapp.services.ClassDetailService;
import vn.csc.webapp.services.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassDetailService classDetailService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String studentManagement(Map<String, Object> map) throws IOException {
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		studentDTOList = studentService.getStudentList();
		map.put("studentList", studentDTOList);
		return "student/show";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addStudent_GET(Map<String, Object> map) {
		return null;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent_POST(HttpServletRequest request, Model viewModel) {

		try {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			studentService.persistStudent(name, email, address);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not create student!");
		}
		return "redirect:/student/";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editStudent_Get(HttpServletRequest request, Map<String, Object> map) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		StudentDTO studentDTO = studentService.getStudentById(studentId);
		map.put("student", studentDTO);
		return "student/update";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser_POST(HttpServletRequest request, Model viewModel) {

		try {
			String studentID = request.getParameter("studentId");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			studentService.updateStudent(Integer.parseInt(studentID), name,
					email, address);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not edit student!");
		}
		return "redirect:/student/";
	}

	@RequestMapping("/delete")
	public String removeStudent(HttpServletRequest request, Map<String, Object> map) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		studentService.removeStudent(studentId);
		return "redirect:/student/";
	}
	
	@RequestMapping(value = "/detail")
	public String detail_Get(HttpServletRequest request, Map<String, Object> map) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		StudentDTO studentDTO = studentService.getStudentById(studentId);
		List<ClazzDTO> classDTOList = studentService.getClassByStudentId(studentId);
		map.put("student", studentDTO);
		map.put("classList", classDTOList);
		return "student/detail";
	}
}
