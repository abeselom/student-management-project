package vn.csc.utils;

import java.util.ArrayList;
import java.util.List;

import vn.csc.finalproject.dto.ClazzDTO;
import vn.csc.finalproject.dto.ClazzDetailDTO;
import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.finalproject.dto.UserDTO;
import vn.csc.finalproject.ejb.entity.Clazz;
import vn.csc.finalproject.ejb.entity.ClazzDetail;
import vn.csc.finalproject.ejb.entity.Student;
import vn.csc.finalproject.ejb.entity.User;

public class DTOUtils {
	
	public List<Integer> getStudentIdListOfClazz(List<ClazzDetail> clazzDetailList) {
		List<Integer> studentIdList = new ArrayList<Integer>();
		for (ClazzDetail clazzDetail : clazzDetailList) {
			studentIdList.add(clazzDetail.getStudent().getStudentId());
		}
		return studentIdList;
	}
	
	public List<Integer> getClazzIdListOfStudent(List<ClazzDetail> clazzDetailList) {
		List<Integer> clazzIdList = new ArrayList<Integer>();
		for (ClazzDetail clazzDetail : clazzDetailList) {
			clazzIdList.add(clazzDetail.getClazz().getClazz_ID());
		}
		return clazzIdList;
	}
	
	public ClazzDTO convertClazzToClazzDTO(Clazz clazz) {
		ClazzDTO clazzDTO = new ClazzDTO();
		clazzDTO.setClazz_ID(clazz.getClazz_ID());
		clazzDTO.setDaytime(clazz.getDaytime());
		clazzDTO.setSubject(clazz.getSubject());
		clazzDTO.setStudentIdList(getStudentIdListOfClazz(clazz.getClazzDetails()));
		return clazzDTO;
		
	}
	
	public StudentDTO convertStudentToStudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(student.getStudentId());
		studentDTO.setName(student.getName());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setClazzIdList(getClazzIdListOfStudent(student.getClazzDetails()));
		return studentDTO;
	}

	public UserDTO convertUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setType(user.getType());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}
	
	public User convertUserDTOToUser(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setType(userDTO.getType());
		user.setEmail(userDTO.getEmail());
		return user;
	}
	
	public Student convertStudentDTOToStudent(StudentDTO studentDTO) {
		Student student = new Student();
		student.setStudentId(studentDTO.getStudentId());
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		//student.setClazzIdList(getClazzIdListOfStudent(student.getClazzDetails()));
		return student;
	}
	
	public ClazzDetailDTO convertClazzDetailToClazzDetailDTO(ClazzDetail clazzDetail) {
		ClazzDetailDTO clazzDetailDTO = new ClazzDetailDTO();
		clazzDetailDTO.setClazz_DETAIL_ID(clazzDetail.getClazz_DETAIL_ID());
		clazzDetailDTO.setClazzDTOId(clazzDetail.getClazz().getClazz_ID());
		clazzDetailDTO.setStudentDTOId(clazzDetail.getStudent().getStudentId());
		return clazzDetailDTO;
	}
}
