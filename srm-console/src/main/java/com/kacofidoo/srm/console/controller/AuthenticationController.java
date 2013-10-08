/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.console.service.UserService;
import com.kacofidoo.srm.console.utils.LoginUtils;
import com.kacofidoo.srm.console.vo.LoginCommand;
import com.kacofidoo.srm.orm.entity.User;

/**
 * @author Jeff.Tsai
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

	private static final Log log = LogFactory.getLog(AuthenticationController.class);

	@Resource(name = "userService")
	private UserService userService;

	@RequiresAuthentication
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.html";
	}

	@RequestMapping(value = "/login")
	@RequiresGuest
	public String login(HttpServletRequest request, HttpServletResponse response, LoginCommand loginCommand) {

		int loginCode;

		if (SecurityUtils.getSubject().isAuthenticated()) {
			loginCode = LoginUtils.LOGIN_SUCCESS;
		} else {
			loginCode = LoginUtils.login(loginCommand);

		}

		// 验证是否成功登录的方法
		if (loginCode != LoginUtils.LOGIN_SUCCESS) {
			return "redirect:/login.jsp?errorCode=" + loginCode;
		} else {
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("username", loginCommand.getUsername());
			session.setAttribute("loginType", loginCommand.getLoginType());
			session.setAttribute("loginTimeMills", System.currentTimeMillis());
		}

		try {
			User user = this.userService.getCurrentUser();
			if (user.getCompany() == null) {
				return "company_register";
			} else if (loginCommand.getLoginType() == LoginCommand.LOGIN_TYPE_BUYER) {
				return "index_buyer";
			} else if (loginCommand.getLoginType() == LoginCommand.LOGIN_TYPE_SELL) {
				return "index_sell";
			} else if (loginCommand.getLoginType() == LoginCommand.LOGIN_TYPE_ROOT) {
				return "index_root";
			}
		} catch (SrmException e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/switch/{type}")
	@RequiresAuthentication
	public String switchLoginType(@PathVariable("type") String type) throws SrmException {
		Session session = SecurityUtils.getSubject().getSession();
		if (StringUtils.equalsIgnoreCase(type, "sell")) {
			session.setAttribute("loginType", LoginCommand.LOGIN_TYPE_SELL);
		} else if (StringUtils.equalsIgnoreCase(type, "buyer")) {
			session.setAttribute("loginType", LoginCommand.LOGIN_TYPE_BUYER);
		}

		int loginType = (Integer) session.getAttribute("loginType");
		if (loginType == LoginCommand.LOGIN_TYPE_BUYER) {
			return "index_buyer";
		} else if (loginType == LoginCommand.LOGIN_TYPE_SELL) {
			return "index_sell";
		} else {
			final String errmsg = "switch login type failed: unknow login type " + loginType;
			if (log.isErrorEnabled()) {
				log.error(errmsg);
			}
			throw new SrmException(errmsg);
		}

	}
}
