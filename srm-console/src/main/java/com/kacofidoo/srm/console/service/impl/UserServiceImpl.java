/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.service.impl;

import java.util.Date;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.console.service.UserService;
import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.AbstractEntity;
import com.kacofidoo.srm.orm.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Jeff.Tsai
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#load(long)
	 */
	@Override
	public User load(long id) throws SrmException {
		return this.userDao.getUserById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#load(java.lang.String)
	 */
	@Override
	public User load(String username) throws SrmException {
		return this.userDao.getUserByName(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#deleteUserById(long)
	 */
	@Override
	public void deleteUserById(long id) throws SrmException {
		User user = this.userDao.getUserById(id);
		user.setStatus(AbstractEntity.STORE_DELETE);
		user.setModifyTime(new Date());
		this.userDao.update(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#deleteUserByName(java.lang.String)
	 */
	@Override
	public void deleteUserByName(String name) throws SrmException {
		// TODO Auto-generated method stub
		User user = this.userDao.getUserByName(name);
		user.setStatus(AbstractEntity.STORE_DELETE);
		user.setModifyTime(new Date());
		this.userDao.update(user);
	}

	@Override
	@Transactional
	public void register(User user) throws SrmException {
		user.setCreateTime(new Date());
		this.userDao.insert(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#queryWithPage(int, int, java.lang.String, java.lang.Long)
	 */
	@Override
	public void queryWithPage(int pageNo, int pageSize, String username, Long companyId) throws SrmException {

	}

}
