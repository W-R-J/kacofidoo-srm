package com.kacofidoo.srm.orm.dao;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath*:*/*-context.xml" })
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ TransactionalTestExecutionListener.class })
@Transactional
public class UserDaoTest {

	@Resource(name = "userDao")
	UserDao userDao;

	@Test
	public void testCountAll() {
		System.out.println(this.userDao.countAll());
	}

	@Test
	public void testGetUserById() {
		fail("Not yet implemented");
	}

}
