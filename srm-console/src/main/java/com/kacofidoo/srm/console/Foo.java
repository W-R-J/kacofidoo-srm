package com.kacofidoo.srm.console;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kacofidoo.srm.common.exception.SrmDaoException;
import com.kacofidoo.srm.common.utils.JsonUtils;
import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.User;

@Controller
@RequestMapping("/foo")
public class Foo {

	@Resource(name = "userDao")
	private UserDao userDao;

	@RequestMapping("/ready")
	public String ready(Model model) throws SrmDaoException {
		model.addAttribute("nowtime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		model.addAttribute("countAll", this.userDao.countAll());
		User user = this.userDao.getUserById(1);
		model.addAttribute("pojo", JsonUtils.toJson(user));
		return "ready";
	}

}
