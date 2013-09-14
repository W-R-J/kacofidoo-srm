package com.kacofidoo.srm.orm.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -7006104508397409972L;

	private String id;
	private String name;
	private String nickname;
	private int age;
	private int gender;
	private String companyId;
	private String password;
	private int type;

	public int getAge() {
		return age;
	}

	public String getCompanyId() {
		return companyId;
	}

	public int getGender() {
		return gender;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public int getType() {
		return type;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(int type) {
		this.type = type;
	}
}
