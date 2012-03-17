package vn.csc.finalproject.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;
	private int type;

    public User() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}