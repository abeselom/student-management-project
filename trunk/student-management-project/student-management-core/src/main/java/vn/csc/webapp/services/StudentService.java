package vn.csc.webapp.services;

import java.util.List;

import vn.csc.finalproject.dto.ClazzDTO;
import vn.csc.finalproject.dto.StudentDTO;

public interface StudentService {
	public int getNumberOfStudents();

	public List<StudentDTO> getStudentList();

	public StudentDTO getStudentById(int studentId);

	public List<ClazzDTO> getClassByStudentId(int studentId);
}