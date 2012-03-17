package vn.csc.finalproject.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int studentId;
	private String address;
	private String email;
	private String name;
	private List<ClazzDetail> clazzDetails;

    public Student() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to ClazzDetail
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
	public List<ClazzDetail> getClazzDetails() {
		return this.clazzDetails;
	}

	public void setClazzDetails(List<ClazzDetail> clazzDetails) {
		this.clazzDetails = clazzDetails;
	}
	
}