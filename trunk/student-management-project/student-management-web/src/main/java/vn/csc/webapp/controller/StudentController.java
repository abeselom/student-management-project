package vn.csc.webapp.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.finalproject.dto.UserDTO;
import vn.csc.webapp.common.Function;
import vn.csc.webapp.services.StudentService;
@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String studentManagement(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
//
//		if (!Function.check_login(request, response)) {
//			response.sendRedirect("login");
//			return null;
//		}

//		ModelAndView modelAndView = new ModelAndView("StudentManagementOutput");
		
		
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		studentDTOList = studentservice.getStudentList();
		  Map paramMap = WebUtils.getParametersStartingWith(request, "d-");
          if (paramMap.size() == 0) {
              WebUtils.setSessionAttribute(request, "userList", studentDTOList);
          }
//		String mes = request.getParameter("q");
//		modelAndView.addObject("mess", mes);
          return "student/StudentManagementOutput";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addStudent_GET(Map<String, Object> map) {
		return null;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent_POST(HttpServletRequest request, Model viewModel) {
		
		try {
			String fullname = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			
//			userService.persistUser(username, password, email, type);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not create student!");
		}
		return "redirect:/student/StudentManagement";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser_GET(HttpServletRequest request, Map<String, Object> map) {
		String studentId = request.getParameter("studentId");
		StudentDTO studentDTO = studentservice.getStudentById(Integer.parseInt(studentId));
		return "student/update";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser_POST(HttpServletRequest request, Model viewModel) {
		
		try {
			String studentID = request.getParameter("studentId");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			
			studentservice.updateStudent(Integer.parseInt(studentID), name, email, address);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not edit student!");
		}
		return "redirect:/student/";
	}
	
	@RequestMapping("/delete")
	public String removeUser_Post(HttpServletRequest request, Map<String, Object> map) {
		String studentId = request.getParameter("studentId");
		studentservice.removeStudent(Integer.parseInt(studentId));
		return "redirect:/student/";
	}
}
