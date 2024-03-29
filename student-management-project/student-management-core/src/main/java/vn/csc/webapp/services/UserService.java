package vn.csc.webapp.services;

import java.util.List;

import vn.csc.finalproject.dto.UserDTO;

public interface UserService {
	public UserDTO persistUser(String username, String password, String email, int type);

	public void updateUser(String username, String email, int type);

	public void removeUser(String username);

	public List<UserDTO> getUserList();

	public UserDTO getUserByName(String username);

	public UserDTO changeUserPermission(String Username, int iType);

	public boolean userExisted(String username);

	public boolean LogIn(String username, String password);
	
	public void changePassword(String username, String password);
}
