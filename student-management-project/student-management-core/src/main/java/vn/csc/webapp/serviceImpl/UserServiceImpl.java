package vn.csc.webapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import vn.csc.finalproject.dto.UserDTO;
import vn.csc.finalproject.ejb.entity.User;
import vn.csc.finalproject.ejb.entity.user.UserBeanRemote;
import vn.csc.utils.ContextUtil;
import vn.csc.utils.DTOUtils;
import vn.csc.utils.HashPasswordUtil;
import vn.csc.webapp.services.UserService;

public class UserServiceImpl implements UserService {
	private UserBeanRemote userBeanRemote;
	protected HashPasswordUtil hashCodeService = new HashPasswordUtil();
	protected DTOUtils convertService = new DTOUtils();

	public UserServiceImpl() {
		try {
			ContextUtil contextUtil = new ContextUtil();
			this.userBeanRemote = (UserBeanRemote) contextUtil
					.getInitialContext()
					.lookup("user#vn.csc.finalproject.ejb.entity.user.UserBeanRemote");
		} catch (NamingException e) {
			this.userBeanRemote = null;
			System.err.println(e.getMessage().toString());
		}
	}

	@Override
	public UserDTO persistUser(String username, String password, String email,
			int type) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(hashCodeService.hashMd5(password));
		user.setType(type);
		userBeanRemote.persistUser(user);
		return convertService.convertUserToUserDTO(user);
	}

	@Override
	public void updateUser(String username, String email, int type) {
		userBeanRemote.updateUser(username, email, type);
	}

	@Override
	public void removeUser(String username) {
		userBeanRemote.removeUser(username);
	}

	@Override
	public List<UserDTO> getUserList() {
		List<User> userList = new ArrayList<User>();
		List<UserDTO> userListDTO = new ArrayList<UserDTO>();
		userList = userBeanRemote.getUserList();
		for (User user : userList) {
			UserDTO userDTO = new UserDTO();
			userDTO = convertService.convertUserToUserDTO(user);
			userListDTO.add(userDTO);
		}
		return userListDTO;
	}

	@Override
	public UserDTO getUserByName(String username) {
		User user = userBeanRemote.getUserByName(username);
		return convertService.convertUserToUserDTO(user);
	}

	@Override
	public UserDTO changeUserPermission(String Username, int iType) {
		User user = userBeanRemote.changeUserPermission(Username, iType);
		return convertService.convertUserToUserDTO(user);
	}

	@Override
	public boolean userExisted(String username) {
		return userBeanRemote.userExisted(username);
	}

	@Override
	public boolean LogIn(String username, String password) {
		String hashPassword = hashCodeService.hashMd5(password);
		return userBeanRemote.LogIn(username, hashPassword);
	}
	
	public static void main(String[] args) {
		UserServiceImpl ssi = new UserServiceImpl();
		System.out.println(ssi.getUserByName("admin"));
		System.out.println(ssi.userExisted("admin"));
		System.out.println(ssi.userExisted("abc"));
		System.out.println(ssi.getUserList().get(1).getEmail());
		//System.out.println(ssi.persistUser("tu6", "tu", "tu@yahoo.com", 1));
		ssi.changePassword("teacher", "123456");
		//ssi.removeStudent(9);
		//System.out.println(ssi.getStudentListByName("student%").size());
	}

	@Override
	public void changePassword(String username, String password) {
		String hashPassword = hashCodeService.hashMd5(password);
		userBeanRemote.changePassword(username, hashPassword);
	}
}
