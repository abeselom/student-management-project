package vn.csc.finalproject.dto;

import java.util.Date;
import java.util.List;

public class ClazzDTO {
	private int clazz_ID;
	private Date daytime;
	private String subject;
	private List<Integer> studentIdList;

	public ClazzDTO() {
	}

	public ClazzDTO(int clazz_ID, Date daytime, String subject,
			List<Integer> studentIdList) {
		super();
		this.clazz_ID = clazz_ID;
		this.daytime = daytime;
		this.subject = subject;
		this.studentIdList = studentIdList;
	}



	public int getClazz_ID() {
		return clazz_ID;
	}

	public void setClazz_ID(int clazz_ID) {
		this.clazz_ID = clazz_ID;
	}

	public Date getDaytime() {
		return daytime;
	}

	public void setDaytime(Date daytime) {
		this.daytime = daytime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Integer> getStudentIdList() {
		return studentIdList;
	}

	public void setStudentIdList(List<Integer> studentId) {
		this.studentIdList = studentId;
	}
}
