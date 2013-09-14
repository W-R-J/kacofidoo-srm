/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kacofidoo.srm.console.service.UserService;

/**
 * @author Jeff.Tsai
 * 
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

	private static final Log log = LogFactory.getLog(AuthenticationController.class);

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/login")
	public String login(String loginName, String loginPassword, int loginType,
			@RequestParam(required = false, value = "isRememberMe", defaultValue = "false") boolean isRememberMe,
			HttpServletRequest request, HttpServletResponse response) {
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPassword);
		// 记录该令牌
		token.setRememberMe(isRememberMe);
		// subject权限对象
		Subject subject = SecurityUtils.getSubject();
		int errorCode = 3;
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
			if (log.isDebugEnabled()) {
				log.debug(ex);
			}
			ex.printStackTrace();
		}

		// 验证是否成功登录的方法
		if (subject.isAuthenticated()) {
			return "index";
		}
		return "redirect:/login.html?errorCode=" + errorCode;
	}

}
