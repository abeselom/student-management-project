package vn.csc.finalproject.ejb.entity.student;

import java.util.List;

import javax.ejb.Remote;

import vn.csc.finalproject.ejb.entity.Clazz;
import vn.csc.finalproject.ejb.entity.Student;

@Remote
public interface StudentBeanRemote {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public Student persistStudent(Student student);

	public boolean removeStudent(int studentId);
	
	public List<Student> getAllStudent();
	
	public int getNumberOfStudents();
	
    public Student getStudentById(int studentId);
    
    public List<Clazz> getClassByStudentId(int studentId);
    
    public boolean studentExited(int id);
    
    public List<Student> getStudentListByName(String name);
    
    public void updateStudent(int studentId, String name, String email, String address);
}
