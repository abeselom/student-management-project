package vn.csc.finalproject.ejb.entity.clazzdetail;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vn.csc.finalproject.ejb.entity.ClazzDetail;
import vn.csc.finalproject.ejb.entity.Student;

@Stateless(name = "ClazzDetailBean", mappedName = "clazzDetail")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClazzDetailBean implements ClazzDetailBeanLocal,
		ClazzDetailBeanRemote {

	@PersistenceContext(unitName = "ejb-core")
	private EntityManager em;

	public ClazzDetailBean() {
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

	public ClazzDetail persistClazzDetail(ClazzDetail clazzDetail) {
		try {
			em.persist(clazzDetail);
			em.flush();
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
		return clazzDetail;
	}

	public ClazzDetail mergeClazzDetail(ClazzDetail clazzDetail) {
		try {
			return em.merge(clazzDetail);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	public void removeClazzDetail(ClazzDetail clazzDetail) {
		try {
			clazzDetail = em.find(ClazzDetail.class,
					clazzDetail.getClazz_DETAIL_ID());
			if (clazzDetail != null) {
				em.remove(clazzDetail);
			}
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> GetStudentByClass(int ClazzID) {
		String str = "SELECT DISTINCT stu FROM Student stu WHERE stu.student_id IN "
				+ "(SELECT detail.student_id FROM ClazzDetail detail WHERE detail.clazz_id = :id)";
		Query query = em.createQuery(str);
		query.setParameter("id", ClazzID);
		List<Student> rs = (List<Student>) query.getResultList();
		return rs;
	}
}
