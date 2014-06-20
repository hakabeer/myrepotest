package com.web.app.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name="User")
@NamedQueries({
@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
@NamedQuery(
	    name="User.findByEmailByPassword",
	    query="SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=64)
	private String email;

	@Column(nullable=false, length=45)
	private String firstname;

	@Column(nullable=false, length=45)
	private String lastname;

	@Column(nullable=false)
	private int organizationId;

	@Column(nullable=false, length=128)
	private String password;

	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}