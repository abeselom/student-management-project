package vn.csc.webapp.services;

import java.util.List;

import vn.csc.finalproject.dto.ClazzDTO;
import vn.csc.finalproject.dto.StudentDTO;

public interface StudentService {
	public StudentDTO persistStudent(String name, String email, String address);

	public StudentDTO mergeStudent(StudentDTO studentDTO);

	public void removeStudent(StudentDTO studentDTO);

	public int getNumberOfStudents();

	public List<StudentDTO> getStudentList();

	public StudentDTO getStudentById(int studentId);

	public List<ClazzDTO> getClassByStudentId(int studentId);
}