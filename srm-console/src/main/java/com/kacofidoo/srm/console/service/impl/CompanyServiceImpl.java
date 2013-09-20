/**
 * 
 */
package com.kacofidoo.srm.console.service.impl;

import org.springframework.stereotype.Service;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.console.service.CompanyService;
import com.kacofidoo.srm.orm.entity.Company;
import com.kacofidoo.srm.orm.page.Page;

/**
 * @author Jeff.Tsai
 * 
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.CompanyService#load(long)
	 */
	@Override
	public Company load(long id) throws SrmException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.CompanyService#queryByName(java.lang.String)
	 */
	@Override
	public Company queryByName(String companyName) throws SrmException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.CompanyService#register(com.kacofidoo.srm.orm.entity.Company)
	 */
	@Override
	public void register(Company company) throws SrmException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.CompanyService#queryWithPage(int, int)
	 */
	@Override
	public Page<Company> queryWithPage(int pageNo, int pageSize) throws SrmException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.console.service.CompanyService#delete(long)
	 */
	@Override
	public void delete(long id) throws SrmException {
		// TODO Auto-generated method stub

	}

}
