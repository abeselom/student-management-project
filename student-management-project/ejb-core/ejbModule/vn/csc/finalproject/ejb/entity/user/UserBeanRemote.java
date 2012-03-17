package vn.csc.finalproject.ejb.entity.user;

import java.util.List;

import javax.ejb.Remote;
import vn.csc.finalproject.ejb.entity.User;

@Remote
public interface UserBeanRemote {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public User persistUser(User user);

	public User mergeUser(User user);

	public void removeUser(User user);

	public List<User> getUserList();

	public User getUserByName(String username);

	public User changeUserPermission(String Username, int iType);
	
	public boolean userExisted(String username);
	
	public User LogIn(String username, String password);
}
