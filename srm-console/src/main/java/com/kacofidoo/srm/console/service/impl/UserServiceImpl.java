/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kacofidoo.srm.console.service.UserService;
import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.User;

/**
 * @author Jeff.Tsai
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#getUserByName(java.lang.String)
	 */
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#deleteUserById(java.lang.String)
	 */
	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#deleteUserByName(java.lang.String)
	 */
	@Override
	public void deleteUserByName(String name) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#queryWithPage(int, int)
	 */
	@Override
	public void queryWithPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub

	}

}
