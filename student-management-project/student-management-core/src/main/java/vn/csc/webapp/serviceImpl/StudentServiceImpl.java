package vn.csc.webapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import vn.csc.finalproject.dto.ClazzDTO;
import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.finalproject.ejb.entity.Clazz;
import vn.csc.finalproject.ejb.entity.Student;
import vn.csc.finalproject.ejb.entity.student.StudentBeanRemote;
import vn.csc.utils.ContextUtil;
import vn.csc.utils.DTOUtils;
import vn.csc.webapp.services.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentBeanRemote studentBeanRemote;
	protected DTOUtils convertService = new DTOUtils();

	@Override
	public void removeStudent(int studentId) {
		studentBeanRemote.removeStudent(studentId);
	}

	public StudentServiceImpl() {
		try {
			ContextUtil contextUtil = new ContextUtil();
			this.studentBeanRemote = (StudentBeanRemote) contextUtil.getInitialContext().lookup("student#vn.csc.finalproject.ejb.entity.student.StudentBeanRemote");
		} catch (NamingException e) {
			this.studentBeanRemote = null;
			System.err.println(e.getMessage().toString());
		}
	}

	@Override
	public int getNumberOfStudents() {
		int numberOfStudents = 0;
		if (studentBeanRemote != null)
			numberOfStudents = studentBeanRemote.getNumberOfStudents();
		return numberOfStudents;
	}

	@Override
	public List<StudentDTO> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		if (studentBeanRemote != null)
			studentList = studentBeanRemote.getAllStudent();
		for (Student student : studentList) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO = convertService.convertStudentToStudentDTO(student);
			studentDTOList.add(studentDTO);
		}
		return studentDTOList;
	}

	@Override
	public StudentDTO getStudentById(int studentId) {
		Student student = studentBeanRemote.getStudentById(studentId);
		StudentDTO studentDTO = convertService.convertStudentToStudentDTO(student);
		return studentDTO;
	}

	@Override
	public List<ClazzDTO> getClassByStudentId(int studentId) {
		List<Clazz> clazzList = new ArrayList<Clazz>();
		clazzList = studentBeanRemote.getClassByStudentId(studentId);
		List<ClazzDTO> clazzDTOList = new ArrayList<ClazzDTO>();
		for (Clazz clazz : clazzList) {
			clazzDTOList.add(convertService.convertClazzToClazzDTO(clazz));
		}
		return clazzDTOList;
	}

	@Override
	public void persistStudent(String name, String email, String address) {
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		studentBeanRemote.persistStudent(student);
	}

	@Override
	public void updateStudent(int studentId, String name, String email, String address) {
		studentBeanRemote.updateStudent(studentId, name, email, address);
	}

	@Override
	public List<StudentDTO> getStudentListByName(String name) {
		List<Student> studentList = new ArrayList<Student>();
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		if (studentBeanRemote != null)
			studentList = studentBeanRemote.getStudentListByName(name);
		for (Student student : studentList) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO = convertService.convertStudentToStudentDTO(student);
			studentDTOList.add(studentDTO);
		}
		return studentDTOList;
	}
	
	public static void main(String[] args) {
		StudentServiceImpl ssi = new StudentServiceImpl();
		//ssi.removeStudent(9);
	}
}
