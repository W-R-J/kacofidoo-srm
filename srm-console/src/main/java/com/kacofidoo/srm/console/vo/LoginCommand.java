/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.vo;

/**
 * @author Jeff.Tsai
 * 
 */
public class LoginCommand {

	// <option value="1">采购商</option>
	// <option value="2">供应商</option>
	// <option value="9">管理员</option>
	public transient static final int LOGIN_TYPE_ROOT = 9;
	public transient static final int LOGIN_TYPE_BUYER = 1;
	public transient static final int LOGIN_TYPE_SELL = 2;

	private String username;
	private String password;
	private int loginType;
	private boolean rememberMe;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

}
