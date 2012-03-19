package vn.csc.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.csc.finalproject.dto.UserDTO;
import vn.csc.webapp.services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String show(Map<String, Object> map) {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		userDTOList = userService.getUserList();
		map.put("number", userDTOList.size());
		map.put("userList", userDTOList);
		return "user/show";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser_GET(Map<String, Object> map) {
		return null;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser_POST(HttpServletRequest request, Model viewModel) {
		
		try {
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			int type = Integer.parseInt(request.getParameter("selection"));
			userService.persistUser(username, password, email, type);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not create user!");
		}
		return "redirect:/user/";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser_GET(HttpServletRequest request, Map<String, Object> map) {
		String username = request.getParameter("username");
		UserDTO userDTO = userService.getUserByName(username);
		map.put("user", userDTO);
		return "user/update";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser_POST(HttpServletRequest request, Model viewModel) {
		
		try {
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			int type = Integer.parseInt(request.getParameter("selection"));
			userService.updateUser(username, password, email, type);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
			viewModel.addAttribute("error", "Can not edit user!");
		}
		return "redirect:/user/";
	}
	
	
	@RequestMapping("/delete")
	public String removeUser_Post(HttpServletRequest request, Map<String, Object> map) {
		String username = request.getParameter("username");
		userService.removeUser(username);
		return "redirect:/user/";
	}
}
