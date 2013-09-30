/**
 * 
 */
package com.kacofidoo.srm.orm.dao;

import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.orm.entity.DataDic;

/**
 * @author weiwei.cai
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/*.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DataDicDaoTest {

	@Inject
	private DataDicDao dataDicDao;

	@Test
	public void testReady() {
		Assert.assertNotNull(this.dataDicDao);
	}

	@Test
	public void testSaveOrUpdate() {
		int oldCount = this.dataDicDao.countAll();
		DataDic dic = new DataDic();
		long catalog = RandomUtils.nextLong();
		dic.setCatalog(catalog);
		dic.setName(RandomStringUtils.randomAlphanumeric(8));
		dic.setValue(UUID.randomUUID().toString());

		this.dataDicDao.saveOrUpdate(dic);

		DataDic foo = this.dataDicDao.queryByPropertyForObject("catalog", catalog);
		Assert.assertNotNull(foo);

		Assert.assertTrue(dic.getId() > 0);
		int newCount = this.dataDicDao.countAll();
		Assert.assertEquals(newCount, oldCount + 1);
	}

}
