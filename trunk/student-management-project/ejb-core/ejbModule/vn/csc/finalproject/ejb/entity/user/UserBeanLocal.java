package vn.csc.finalproject.ejb.entity.user;

import javax.ejb.Local;
import vn.csc.finalproject.ejb.entity.User;

@Local
public interface UserBeanLocal {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public User persistUser(User user);

	public User mergeUser(User user);

	public void removeUser(User user);
}
