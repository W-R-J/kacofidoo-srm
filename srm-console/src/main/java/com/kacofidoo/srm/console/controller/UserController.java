package com.kacofidoo.srm.console.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kacofidoo.srm.common.utils.JsonUtils;
import com.kacofidoo.srm.console.service.UserService;
import com.kacofidoo.srm.console.vo.AjaxResponse;
import com.kacofidoo.srm.orm.entity.User;

/**
 * Created with IntelliJ IDEA. User: jeff Date: 9/19/13 Time: 1:14 PM To change this template use File | Settings | File
 * Templates.
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static transient final Log log = LogFactory.getLog(UserController.class);

	@Inject
	private UserService userService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@RequiresAuthentication
	public void register(User user, HttpServletResponse response, HttpServletRequest request) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			this.userService.register(user);
			writer.write(AjaxResponse.success().toString());

			UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
			// 记录该令牌
			token.setRememberMe(true);
			// subject权限对象
			Subject subject = SecurityUtils.getSubject();
			try {
				subject.login(token);
			} catch (UnknownAccountException ex) {// 用户名没有找到
				if (log.isDebugEnabled()) {
					log.debug(ex);
				}
				ex.printStackTrace();
			} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配
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
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getName());
				session.setAttribute("loginType", 1);
				session.setAttribute("loginTimeMills", System.currentTimeMillis());
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (log.isErrorEnabled()) {
				log.error("register new user(" + JsonUtils.toJson(user) + ") error: ", e);
			}
			writer.write(AjaxResponse.failed(e.getMessage()).toString());
		}
	}

}
