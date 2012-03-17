package vn.csc.finalproject.ejb.entity.student;

import java.util.List;

import javax.ejb.Remote;

import vn.csc.finalproject.ejb.entity.Clazz;
import vn.csc.finalproject.ejb.entity.Student;

@Remote
public interface StudentBeanRemote {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public Student persistStudent(Student student);

	public Student mergeStudent(Student student);

	public void removeStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public int getNumberOfStudents();
	
    public Student getStudentById(int studentId);
    
    public List<Clazz> getClassByStudentId(int studentId);
    
    public boolean studentExited(int id);
    
    public boolean studentExited(String name);
}
