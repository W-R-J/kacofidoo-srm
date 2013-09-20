package com.kacofidoo.srm.orm.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.common.exception.SrmDaoException;
import com.kacofidoo.srm.common.utils.JsonUtils;
import com.kacofidoo.srm.common.utils.RandomEntityUtils;
import com.kacofidoo.srm.orm.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/*.xml" })
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ TransactionalTestExecutionListener.class })
@Transactional
public class UserDaoTest {

	@Autowired
	UserDao userDao;

	@Test
	public void testCountAll() throws SrmDaoException {
		System.out.println(this.userDao.countAll());
	}

	@Test
	public void testInsert() throws SrmDaoException {
		int originCount = this.userDao.countAll();
		User user = RandomEntityUtils.next(User.class, "id");
		System.out.println(JsonUtils.toJson(user));
		this.userDao.insert(user);
		Assert.assertEquals(this.userDao.countAll(), originCount + 1);
	}

}
