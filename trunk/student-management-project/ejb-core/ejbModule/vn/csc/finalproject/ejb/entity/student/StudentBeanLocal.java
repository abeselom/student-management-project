package vn.csc.finalproject.ejb.entity.student;

import java.util.List;

import javax.ejb.Local;
import vn.csc.finalproject.ejb.entity.Student;

@Local
public interface StudentBeanLocal {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public Student persistStudent(Student student);

	public Student mergeStudent(Student student);

	public void removeStudent(Student student);
	
	public List<Student> getAllStudent();

	public int getNumberOfStudents();
}
