package vn.csc.finalproject.ejb.entity.clazzdetail;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vn.csc.finalproject.ejb.entity.Clazz;
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
			ClazzDetail cd = em.find(ClazzDetail.class,
					clazzDetail.getClazz_DETAIL_ID());
			cd.setClazz(clazzDetail.getClazz());
			cd.setClazz_DETAIL_ID(clazzDetail.getClazz_DETAIL_ID());
			cd.setStudent(clazzDetail.getStudent());
			return em.merge(cd);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	public void removeClazzDetail(int clazzDetailId) {
		try {
			ClazzDetail clazzDetail = em.find(ClazzDetail.class,
					clazzDetailId);
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
		try {
			String str = "SELECT DISTINCT stu FROM Student stu WHERE stu.studentId IN "
					+ "(SELECT detail.student.studentId FROM ClazzDetail detail WHERE detail.clazz.clazz_ID = :id)";
			Query query = em.createQuery(str);
			query.setParameter("id", ClazzID);
			List<Student> rs = (List<Student>) query.getResultList();
			return rs;
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	@Override
	public ClazzDetail addClazzDetail(int classID, int studentID) {
		Clazz clazz = em.find(Clazz.class, classID);
		Student student = em.find(Student.class, studentID);

		if ((clazz != null) && (student != null)) {
			ClazzDetail cd = new ClazzDetail();
			cd.setClazz(clazz);
			cd.setStudent(student);

			return this.persistClazzDetail(cd);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClazzDetail searchClassDetailbyClassAndStudent(int classID, int studentID) {
		try {
			String str = "SELECT DISTINCT clazz FROM ClazzDetail clazz WHERE clazz.student.studentId = :stuID AND clazz.clazz.clazz_ID = :claID";
			Query query = em.createQuery(str);
			query.setParameter("claID", classID);
			query.setParameter("stuID", studentID);
			List<ClazzDetail> rs = (List<ClazzDetail>) query.getResultList();
			return rs.get(0);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}
}
