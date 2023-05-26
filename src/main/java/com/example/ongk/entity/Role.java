package com.example.ongk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;

	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<>();

	public Role(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public Role() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
