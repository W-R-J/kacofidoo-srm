package com.kacofidoo.srm.console.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kacofidoo.srm.common.utils.JsonUtils;
import com.kacofidoo.srm.console.service.UserService;
import com.kacofidoo.srm.console.utils.LoginUtils;
import com.kacofidoo.srm.console.vo.AjaxResponse;
import com.kacofidoo.srm.console.vo.LoginCommand;
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
	public void register(User user, HttpServletResponse response, HttpServletRequest request) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			this.userService.register(user);
			writer.write(AjaxResponse.success().toString());
		} catch (Exception e) {
			e.printStackTrace();
			if (log.isErrorEnabled()) {
				log.error("register new user(" + JsonUtils.toJson(user) + ") error: ", e);
			}
			writer.write(AjaxResponse.failed(e.getMessage()).toString());
		}
	}

}
