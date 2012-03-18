package vn.csc.finalproject.ejb.entity.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vn.csc.finalproject.ejb.entity.User;

@Stateless(name = "UserBean", mappedName = "user")
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

	public User persistUser(User user) {
		em.persist(user);
		return user;
	}

	public User mergeUser(User user) {
		return em.merge(user);
	}

	public void removeUser(User user) {
		user = em.find(User.class, user.getUsername());
		em.remove(user);
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
		boolean rs = true;
		if (this.getUserByName(username) == null)
			rs = false;
		return rs;
	}
}
