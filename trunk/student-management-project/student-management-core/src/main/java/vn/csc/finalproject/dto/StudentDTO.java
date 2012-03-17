package vn.csc.finalproject.dto;

import java.util.List;

public class StudentDTO {
	private int studentId;
	private String address;
	private String email;
	private String name;
	private List<Integer> clazzIdList;

	public StudentDTO() {
	}

	public StudentDTO(int studentId, String address, String email, String name,
			List<Integer> clazzIdList) {
		super();
		this.studentId = studentId;
		this.address = address;
		this.email = email;
		this.name = name;
		this.clazzIdList = clazzIdList;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getClazzIdList() {
		return clazzIdList;
	}

	public void setClazzIdList(List<Integer> clazzId) {
		this.clazzIdList = clazzId;
	}
}
