/**
 * 
 */
package com.kacofidoo.srm.console.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.kacofidoo.srm.console.vo.LoginCommand;

/**
 * @author weiwei.cai
 * 
 */
public class LoginUtils {
	public transient static final int LOGIN_SUCCESS = 0;

	private transient static final Log log = LogFactory.getLog(LoginUtils.class);

	public static final int login(LoginCommand cmd) {
		UsernamePasswordToken token = new UsernamePasswordToken(cmd.getUsername(), cmd.getPassword());
		// 记录该令牌
		token.setRememberMe(cmd.isRememberMe());
		// subject权限对象
		Subject subject = SecurityUtils.getSubject();
		int errorCode = LOGIN_SUCCESS;
		try {
			subject.login(token);
		} catch (UnknownAccountException ex) {// 用户名没有找到
			errorCode = 1;
			if (log.isDebugEnabled()) {
				log.debug(ex);
			}
			ex.printStackTrace();
		} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配
			errorCode = 2;
			if (log.isDebugEnabled()) {
				log.debug(ex);
			}
			ex.printStackTrace();
		} catch (AuthenticationException ex) {// 其他的登录错误
			errorCode = 3;
			if (log.isDebugEnabled()) {
				log.debug(ex);
			}
			ex.printStackTrace();
		}
		return errorCode;
	}
}
