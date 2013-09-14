package com.kacofidoo.srm.orm.entity;

import java.io.Serializable;

/**
 * 用户
 * 
 * @author Jeff.Tsai
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = -7006104508397409972L;

	public static final int COMPANY_ROLE_ADMIN = 9;
	public static final int COMPANY_ROLE_DEFAULT = 0;

	public static final int GENDER_UNKNOW = 0;
	public static final int GENDER_MALE = 1;
	public static final int GENDER_FEMALE = 2;

	private String id;
	private String name;
	private String nickname;
	private int age;
	private int gender;
	private String companyId;
	private int companyAdminFlag;
	private String password;

	private int systemAdminFlag;
	private int purchaserFlag;
	private int saleFlag;

	public int getAge() {
		return age;
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

	public int getPurchaserFlag() {
		return purchaserFlag;
	}

	public int getSaleFlag() {
		return saleFlag;
	}

	public int getSystemAdminFlag() {
		return systemAdminFlag;
	}

	public void setAge(int age) {
		this.age = age;
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

	public void setPurchaserFlag(int purchaserFlag) {
		this.purchaserFlag = purchaserFlag;
	}

	public void setSaleFlag(int saleFlag) {
		this.saleFlag = saleFlag;
	}

	public void setSystemAdminFlag(int systemAdminFlag) {
		this.systemAdminFlag = systemAdminFlag;
	}

}