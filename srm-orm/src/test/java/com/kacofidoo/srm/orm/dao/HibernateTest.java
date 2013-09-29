/**
 * 
 */
package com.kacofidoo.srm.orm.dao;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.orm.dao.impl.DataDicDaoImpl;

/**
 * @author weiwei.cai
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/*.xml" })
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ TransactionalTestExecutionListener.class })
@Transactional
public class HibernateTest {

	@Inject
	private DataDicDaoImpl dataDicDao;

	@Test
	public void testReady() {
		Assert.assertNotNull(this.dataDicDao);
	}
}
