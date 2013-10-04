/**
 * 
 */
package com.kacofidoo.srm.orm.dao;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weiwei.cai
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/*.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class HibernateTest {

	@Inject
	private DataDicDao dataDicDao;

	@Test
	public void testReady() {
		Assert.assertNotNull(this.dataDicDao);
	}
}
