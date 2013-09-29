package com.kacofidoo.srm.orm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户
 * 
 * @author Jeff.Tsai
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity {

	private static final long serialVersionUID = -7006104508397409972L;

	public static final int COMPANY_ROLE_ADMIN = 9;
	public static final int COMPANY_ROLE_DEFAULT = 0;

	public static final int GENDER_UNKNOW = 0;
	public static final int GENDER_MALE = 1;
	public static final int GENDER_FEMALE = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name", length = 255, nullable = false, unique = true)
	private String name;
	@Column(name = "nickname", length = 255, nullable = true, unique = false)
	private String nickname;
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "gender", length = 1)
	private int gender;
	@ManyToOne
	private Company company;
	@Column(name = "company_admin_flag", length = 1)
	private int companyAdminFlag;
	@Column(name = "password", length = 60, nullable = false)
	private String password;
	@Column(name = "system_admin_flag")
	private int systemAdminFlag;

	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	public int getCompanyAdminFlag() {
		return companyAdminFlag;
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

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	public void setCompanyAdminFlag(int companyAdminFlag) {
		this.companyAdminFlag = companyAdminFlag;
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