package vn.csc.finalproject.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clazz database table.
 * 
 */
@Entity
public class Clazz implements Serializable {
	private static final long serialVersionUID = 1L;
	private int clazz_ID;
	private Date daytime;
	private String subject;
	private List<ClazzDetail> clazzDetails;

    public Clazz() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getClazz_ID() {
		return this.clazz_ID;
	}

	public void setClazz_ID(int clazz_ID) {
		this.clazz_ID = clazz_ID;
	}


    @Temporal( TemporalType.TIMESTAMP)
	public Date getDaytime() {
		return this.daytime;
	}

	public void setDaytime(Date daytime) {
		this.daytime = daytime;
	}


	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	//bi-directional many-to-one association to ClazzDetail
	@OneToMany(mappedBy="clazz", fetch=FetchType.EAGER)
	public List<ClazzDetail> getClazzDetails() {
		return this.clazzDetails;
	}

	public void setClazzDetails(List<ClazzDetail> clazzDetails) {
		this.clazzDetails = clazzDetails;
	}
	
}