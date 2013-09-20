package com.kacofidoo.srm.orm.entity;

import java.util.Date;

/**
 * 用户
 * 
 * @author Jeff.Tsai
 */
public class User extends AbstractEntity {

	private static final long serialVersionUID = -7006104508397409972L;

	public static final int COMPANY_ROLE_ADMIN = 9;
	public static final int COMPANY_ROLE_DEFAULT = 0;

	public static final int GENDER_UNKNOW = 0;
	public static final int GENDER_MALE = 1;
	public static final int GENDER_FEMALE = 2;

	private long id;

	private String name;

	private String nickname;

	private Date birthday;

	private int gender;

	private String companyId;

	private int companyAdminFlag;

	private String password;

	private int systemAdminFlag;

	public Date getBirthday() {
		return birthday;
	}

	public int getCompanyAdminFlag() {
		return companyAdminFlag;
	}

	public String getCompanyId() {
		return companyId;
	}

	public int getGender() {
		return gender;
	}

	public long getId() {
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

	public int getSystemAdminFlag() {
		return systemAdminFlag;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setCompanyAdminFlag(int companyAdminFlag) {
		this.companyAdminFlag = companyAdminFlag;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setId(long id) {
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

	public void setSystemAdminFlag(int systemAdminFlag) {
		this.systemAdminFlag = systemAdminFlag;
	}

}