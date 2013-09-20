/**
 * 
 */
package com.kacofidoo.srm.orm.dao;

import junit.framework.Assert;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.common.utils.RandomEntityUtils;
import com.kacofidoo.srm.orm.entity.Company;

/**
 * @author Jeff.Tsai
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/*.xml" })
@TransactionConfiguration(defaultRollback = true)
@TestExecutionListeners({ TransactionalTestExecutionListener.class })
@Transactional
public class CompanyDaoTest {

	@Autowired
	private CompanyDao companyDao;
	private Company company;

	/**
	 * Test method for {@link com.kacofidoo.srm.orm.dao.CompanyDao#insert(com.kacofidoo.srm.orm.entity.Company)}.
	 */
	@Test
	public void testInsert() {
		company = RandomEntityUtils.next(Company.class, "id");
		this.companyDao.insert(company);
		Assert.assertTrue(company.getId() > 0);
	}

	/**
	 * Test method for {@link com.kacofidoo.srm.orm.dao.CompanyDao#load(long)}.
	 */
	@Test
	public void testLoad() {
		Company pojo = this.companyDao.load(company.getId());
		Assert.assertNotNull(pojo);
	}

	/**
	 * Test method for {@link com.kacofidoo.srm.orm.dao.CompanyDao#update(com.kacofidoo.srm.orm.entity.Company)}.
	 */
	@Test
	public void testUpdate() {
		String oldName = this.company.getName();
		String newName = RandomStringUtils.randomAlphanumeric(8);
		this.company.setName(newName);
		this.companyDao.update(company);
		Company pojo = this.companyDao.load(company.getId());
		Assert.assertEquals(pojo.getName(), newName);
		Assert.assertFalse(StringUtils.equals(oldName, pojo.getName()));
	}

	/**
	 * Test method for {@link com.kacofidoo.srm.orm.dao.CompanyDao#delete(long)}.
	 */
	@Test
	public void testDelete() {
		Assert.assertNotNull(this.companyDao.load(this.company.getId()));
		this.companyDao.delete(this.company.getId());
		Assert.assertNull(this.companyDao.load(this.company.getId()));
	}

}
