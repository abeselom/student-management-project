package vn.csc.finalproject.ejb.entity.user;

import java.util.List;

import javax.ejb.Remote;
import vn.csc.finalproject.ejb.entity.User;

@Remote
public interface UserBeanRemote {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public User persistUser(User user);

	public void removeUser(String username);

	public List<User> getUserList();

	public User getUserByName(String username);

	public User changeUserPermission(String Username, int iType);
	
	public boolean userExisted(String username);
	
	public boolean LogIn(String username, String password);
	
	public void updateUser(String username, String email, int type);
	
	public void changePassword(String username, String password);
}
