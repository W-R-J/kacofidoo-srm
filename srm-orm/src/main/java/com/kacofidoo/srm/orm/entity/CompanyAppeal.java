/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.orm.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 公司注册申诉
 * 
 * @author Jeff.Tsai
 * 
 */
@Entity
@Table(name = "company_appeal")
public class CompanyAppeal implements Serializable {

	private static final long serialVersionUID = -8266131539648633952L;

	public static transient final int APPEAL_STATE_DEFAULT = 0;
	public static transient final int APPEAL_STATE_PASSED = 1;
	public static transient final int APPEAL_STATE_UNPASSED = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "company_name", length = 300, nullable = false)
	private String companyName;// 申诉公司名称
	@Column(name = "company_short_name", length = 300, nullable = true)
	private String companyShortName;// 申诉公司简称
	@Column(name = "company_reg_no", length = 30, nullable = false)
	private String companyRegNo;// 申诉公司注册号
	@Lob
	@Column(name = "credentials_img")
	private Blob credentialsImg;// 证件图片
	@Column(name = "appeal_state", length = 1, nullable = false)
	private int appealState;// 申诉状态
	@Column(name = "create_time", nullable = false)
	private Date createTime;// 申诉时间
	@Column(name = "modify_time", nullable = true)
	private Date modifyTime;// 最近处理时间
	@ManyToOne
	private User operator;// 操作人
	@Column(name = "contact", length = 30, nullable = false)
	private String contact;// 申诉人
	@Column(name = "phone", length = 30, nullable = false)
	private String phone;// 联系电话
	@Column(name = "email", length = 100, nullable = false)
	private String email;// 联系邮箱

	public int getAppealState() {
		return appealState;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyRegNo() {
		return companyRegNo;
	}

	public String getCompanyShortName() {
		return companyShortName;
	}

	public String getContact() {
		return contact;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Blob getCredentialsImg() {
		return credentialsImg;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public User getOperator() {
		return operator;
	}

	public String getPhone() {
		return phone;
	}

	public void setAppealState(int appealState) {
		this.appealState = appealState;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setCredentialsImg(Blob credentialsImg) {
		this.credentialsImg = credentialsImg;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
