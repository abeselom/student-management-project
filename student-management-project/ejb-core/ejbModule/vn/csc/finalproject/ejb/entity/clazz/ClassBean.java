package vn.csc.finalproject.ejb.entity.clazz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import vn.csc.finalproject.ejb.entity.Clazz;

@Stateless(name = "ClassBean", mappedName = "clazz")
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

	public Clazz persistClazz(Clazz clazz) {
		em.persist(clazz);
		return clazz;
	}

	public Clazz mergeClazz(Clazz clazz) {
		return em.merge(clazz);
	}

	public void removeClazz(Clazz clazz) {
		clazz = em.find(Clazz.class, clazz.getClazz_ID());
		em.remove(clazz);
	}
}
