package vn.csc.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		map.put("userList", userDTOList);
		return "user/show";
	}
}
