package vn.csc.webapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.csc.finalproject.dto.ClazzDTO;
import vn.csc.finalproject.dto.ClazzDetailDTO;
import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.webapp.services.ClassDetailService;
import vn.csc.webapp.services.ClassService;

@Controller
@RequestMapping(value = "/classes")
public class ClassController {
	@Autowired
	private ClassService classService;
	
	@Autowired
	private ClassDetailService classDetailService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String show(Map<String, Object> map) {
		List<ClazzDTO> classDTOList = new ArrayList<ClazzDTO>();
		classDTOList = classService.getClazzList();
		map.put("classesList", classDTOList);
		return "classes/show";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addClass_GET(Map<String, Object> map) {
		return null;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addClass_POST(HttpServletRequest request, Model viewModel) {
		
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date date = formatter.parse(request.getParameter("date"));
			String subject = request.getParameter("subject");
			classService.persistClazz(date, subject);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not create class!");
		}
		return "redirect:/classes/";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser_GET(HttpServletRequest request, Map<String, Object> map) {
		int clazzId = Integer.parseInt(request.getParameter("classId"));
		ClazzDTO classDTO = classService.getClazzById(clazzId);
		map.put("class", classDTO);
		return "classes/update";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser_POST(HttpServletRequest request, Model viewModel) {
		try {
			int clazzId = Integer.parseInt(request.getParameter("classId")); 
			Date date = DateFormat.getDateInstance(DateFormat.SHORT).parse(request.getParameter("date"));
			String subject = request.getParameter("subject");
			classService.updateClazz(clazzId, date, subject);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not edit class!");
		}
		return "redirect:/classes/";
	}
	
	
	@RequestMapping("/delete")
	public String removeClass(HttpServletRequest request, Map<String, Object> map) {
		int clazzId = Integer.parseInt(request.getParameter("classId"));
		classService.removeClazz(clazzId);
		return "redirect:/classes/";
	}
	
	@RequestMapping(value = "/detail")
	public String detail_Get(HttpServletRequest request, Map<String, Object> map) {
		int classID = Integer.parseInt(request.getParameter("classId"));
		ClazzDTO clazzDTO = classService.getClazzById(classID);
		List<StudentDTO> studentDTOList = classDetailService.GetStudentByClass(classID);
		map.put("clazz", clazzDTO);
		map.put("studentList", studentDTOList);
		map.put("number", studentDTOList.size());
		return "classes/detail";
	}
	
	@RequestMapping(value = "/unenroll")
	public String unenrollStudent(HttpServletRequest request, Map<String, Object> map) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int clazzId = Integer.parseInt(request.getParameter("classId"));
		ClazzDetailDTO classDetailDTO = classDetailService.searchClassDetailbyClassAndStudent(clazzId, studentId);
		classDetailService.removeClazzDetail(classDetailDTO.getClazz_DETAIL_ID());
		return "redirect:/classes/detail?classId=" + clazzId;
	}
}
