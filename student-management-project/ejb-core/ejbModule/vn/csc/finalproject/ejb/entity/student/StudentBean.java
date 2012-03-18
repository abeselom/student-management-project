package vn.csc.finalproject.ejb.entity.student;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import vn.csc.finalproject.ejb.entity.Clazz;
import vn.csc.finalproject.ejb.entity.Student;

@Stateless(name = "StudentBean", mappedName = "student")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StudentBean implements StudentBeanLocal, StudentBeanRemote {

	@PersistenceContext(unitName = "ejb-core")
	private EntityManager em;
	@Resource(mappedName="jdbc/project")
	DataSource dataSource;
	
	public StudentBean() {
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
	public Student persistStudent(Student student) {
		try {
			em.persist(student);
			em.flush();
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
		return student;

	}

	@Override
	public void updateStudent(int studentId, String name, String email, String address) {
		try {
			Student student = em.find(Student.class, studentId);
			student.setAddress(address);
			student.setEmail(email);
			student.setName(name);
			em.merge(student);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	public boolean removeStudent(int studentId) {
		Student student = em.find(Student.class, studentId);
		if(student != null) {
			em.remove(student);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getNumberOfStudents() {
		try {
			String queryString = "SELECT a FROM Student a";
			Query query = em.createQuery(queryString);
			List<Student> studentList = (List<Student>) query.getResultList();
			return studentList.size();
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		try {
			String queryString = "SELECT a FROM Student a";
			Query query = em.createQuery(queryString);
			List<Student> studentList = (List<Student>) query.getResultList();
			return studentList;
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clazz> getClassByStudentId(int studentId) {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT c FROM Clazz c WHERE c.clazz_ID IN (");
			stringBuilder.append("SELECT clazz.clazz_ID ");
			stringBuilder.append("FROM Clazz clazz, ClazzDetail clazz_detail, Student student ");
			stringBuilder.append("WHERE clazz.clazz_ID = clazz_detail.clazz.clazz_ID ");
			stringBuilder.append("AND clazz_detail.student.studentId = student.studentId ");
			stringBuilder.append("AND student.studentId = :studentId)");
			Query query = em.createQuery(stringBuilder.toString());
			query.setParameter("studentId", studentId);
			List<Clazz> rs = (List<Clazz>) query.getResultList();
			return rs;
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	@Override
	public Student getStudentById(int studentId) {
		return em.find(Student.class, studentId);
	}

	@Override
	public boolean studentExited(int id) {
		boolean rs = true;
		if (this.getStudentById(id) == null) {
			rs = false;
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentListByName(String name) {
		String stringQuery = "SELECT s FROM Student s WHERE s.name LIKE :studentName";
		Query query = em.createQuery(stringQuery);
		query.setParameter("studentName", name);
		List<Student> studentList = (List<Student>)query.getResultList();
		return studentList;
	}
}
