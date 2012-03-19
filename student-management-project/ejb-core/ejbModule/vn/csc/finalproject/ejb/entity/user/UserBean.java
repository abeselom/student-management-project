package vn.csc.finalproject.ejb.entity.user;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vn.csc.finalproject.ejb.entity.User;

@Stateless(name = "UserBean", mappedName = "user")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserBean implements UserBeanLocal, UserBeanRemote {

	@PersistenceContext(unitName = "ejb-core")
	private EntityManager em;

	public UserBean() {
	}

	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		Query query = em.createQuery(jpqlStmt);
		if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
		}

		return query.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User persistUser(User user) {
		try {
			em.persist(user);
			em.flush();
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
		return user;
	}
	
	public void removeUser(String username) {
		try {
			User user = em.find(User.class, username);
			if (user != null) {
				em.remove(user);
			}
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		String str = "SELECT a FROM User a";
		Query query = em.createQuery(str);

		List<User> rs = (List<User>) query.getResultList();

		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User changeUserPermission(String Username, int iType) {
		if (iType < 1 || iType > 2) {
			String str = "SELECT a FROM User a WHERE a.username = :name";
			Query query = em.createQuery(str);
			query.setParameter("name", Username);
			User rs = ((List<User>) query.getResultList()).get(0);
			rs.setType(iType);
			return em.merge(rs);
		}
		return null;
	}

	@Override
	public User getUserByName(String username) {
		return em.find(User.class, username);
	}

	@Override
	public User LogIn(String username, String password) {
		// TODO Auto-generated method stub
		if (!this.userExisted(username)) {
			User user = this.getUserByName(username);
			if (user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean userExisted(String username) {
		// TODO Auto-generated method stub
		boolean rs = true;
		if (this.getUserByName(username) == null)
			rs = false;
		return rs;
	}
	
	public void updateUser(String username, String password, String email, int type) {
		User user = em.find(User.class, username);
		user.setEmail(email);
		user.setPassword(password);
		user.setType(type);
		em.merge(user);
	}
}
