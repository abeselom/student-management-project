package vn.csc.webapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.csc.finalproject.dto.UserDTO;
import vn.csc.webapp.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("userName");
		if(username == null || "".equals(username))
			return "index";
		return "redirect:/home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String index_Post(HttpServletRequest request, Map<String, Object> map) {
		try {
			String username = request.getParameter("txt_id");
			String password = request.getParameter("txt_pass");
			UserDTO userDTO = userService.LogIn(username, password);
			HttpSession session = request.getSession(true);
			session.setAttribute("userName", username);
			session.setAttribute("type", userDTO.getType());
			return "redirect:/home";
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
		return "index";
	}

	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request, Map<String, Object> map) {
		HttpSession session = request.getSession(true);
		int type = (Integer)session.getAttribute("type");
		String fileName = null;
		if(type == 1) {
			fileName = "home_ad";
		} else {
			fileName = "home_ur";
		}
		return fileName;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, Map<String, Object> map) {
		try {
			HttpSession session = request.getSession(true);
			session.setAttribute("userName", "");
			session.setAttribute("type", "");
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
		return "redirect:/";
	}
}