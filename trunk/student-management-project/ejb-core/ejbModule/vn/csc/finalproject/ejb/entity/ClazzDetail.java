package vn.csc.finalproject.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clazz_detail database table.
 * 
 */
@Entity
@Table(name="clazz_detail")
public class ClazzDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int clazz_DETAIL_ID;
	private Clazz clazz;
	private Student student;

    public ClazzDetail() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getClazz_DETAIL_ID() {
		return this.clazz_DETAIL_ID;
	}

	public void setClazz_DETAIL_ID(int clazz_DETAIL_ID) {
		this.clazz_DETAIL_ID = clazz_DETAIL_ID;
	}


	//bi-directional many-to-one association to Clazz
    @ManyToOne
	@JoinColumn(name="clazz_ID")
	public Clazz getClazz() {
		return this.clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	

	//bi-directional many-to-one association to Student
    @ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}