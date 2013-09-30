/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.console.service.UserService;
import com.kacofidoo.srm.orm.dao.CompanyDao;
import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.AbstractEntity;
import com.kacofidoo.srm.orm.entity.Company;
import com.kacofidoo.srm.orm.entity.User;
import com.kacofidoo.srm.orm.page.Page;

/**
 * @author Jeff.Tsai
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;

	@Inject
	private CompanyDao companyDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#load(long)
	 */
	@Override
	public User load(long id) throws SrmException {
		return this.userDao.load(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#load(java.lang.String)
	 */
	@Override
	public User load(String username) throws SrmException {
		return this.userDao.queryByPropertyForObject("name", username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#deleteUserById(long)
	 */
	@Override
	public void deleteUserById(long id) throws SrmException {
		User user = this.userDao.load(id);
		user.setStatus(AbstractEntity.STORE_DELETE);
		user.setModifyTime(new Date());
		this.userDao.saveOrUpdate(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#deleteUserByName(java.lang.String)
	 */
	@Override
	public void deleteUserByName(String name) throws SrmException {
		// TODO Auto-generated method stub
		User user = this.userDao.queryByPropertyForObject("name", name);
		user.setStatus(AbstractEntity.STORE_DELETE);
		user.setModifyTime(new Date());
		this.userDao.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void register(User user) throws SrmException {
		user.setCreateTime(new Date());
		this.userDao.saveOrUpdate(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.UserService#queryWithPage(int, int, java.lang.String, java.lang.Long)
	 */
	@Override
	public Page<User> queryWithPage(int pageNo, int pageSize, String username, Long companyId) throws SrmException {
		Company company = this.companyDao.load(companyId);
		return this.userDao.queryByPropertiesWithPage(new String[] { "name", "company" }, new Object[] { username,
				company }, pageNo, pageSize);
	}

}
