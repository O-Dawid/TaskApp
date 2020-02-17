package com.taskapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	String email;
	@NotEmpty
	String name;
	@Size(min=4)
	String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Task> tasks;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", 
		joinColumns = {@JoinColumn(name="USER_EMAIL", referencedColumnName = "email")},
				inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName = "name")})
	List<Role> roles;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Task> getTask() {
		return tasks;
	}
	public void setTask(List<Task> task) {
		this.tasks = task;
	}
	public List<Role> getRole() {
		return roles;
	}
	public void setRole(List<Role> role) {
		this.roles = role;
	}
	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public User() {
	}
	

}
