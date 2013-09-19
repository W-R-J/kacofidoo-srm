package com.kacofidoo.srm.orm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author Jeff.Tsai
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7006104508397409972L;

    public static final int COMPANY_ROLE_ADMIN = 9;
    public static final int COMPANY_ROLE_DEFAULT = 0;

    public static final int GENDER_UNKNOW = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public int getCompanyAdminFlag() {
        return companyAdminFlag;
    }

    public void setCompanyAdminFlag(int companyAdminFlag) {
        this.companyAdminFlag = companyAdminFlag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSystemAdminFlag() {
        return systemAdminFlag;
    }

    public void setSystemAdminFlag(int systemAdminFlag) {
        this.systemAdminFlag = systemAdminFlag;
    }

    private long id;
    private String name;
    private String nickname;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private int gender;
    private String companyId;
    private int companyAdminFlag;
    private String password;

    private int systemAdminFlag;

}