package vn.csc.finalproject.ejb.entity.clazz;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vn.csc.finalproject.ejb.entity.Clazz;

@Stateless(name = "ClassBean", mappedName = "clazz")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClassBean implements ClassBeanLocal, ClassBeanRemote {

	@PersistenceContext(unitName = "ejb-core")
	private EntityManager em;

	public ClassBean() {
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
	public Clazz persistClazz(Clazz clazz) {
		try {
			em.persist(clazz);
			em.flush();
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
		return clazz;
	}


	public void removeClazz(int clazzId) {
		try {
			Clazz clazz = em.find(Clazz.class, clazzId);
			if (clazz != null) {
				em.remove(clazz);
			}
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	@Override
	public void updateClazz(int clazzId, Date dateTime, String subject) {
		try {
			Clazz clazz = em.find(Clazz.class, clazzId);
			clazz.setDaytime(dateTime);
			clazz.setSubject(subject);
			em.merge(clazz);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clazz> getClazzList() {
		String str = "SELECT a FROM Clazz a";
		Query query = em.createQuery(str);
		List<Clazz> rs = (List<Clazz>) query.getResultList();
		return rs;
	}

	@Override
	public Clazz getClazzById(int clazzId) {
		return em.find(Clazz.class, clazzId);
	}
}
