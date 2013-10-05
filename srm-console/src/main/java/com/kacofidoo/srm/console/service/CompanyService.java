/**
 * 
 */
package com.kacofidoo.srm.console.service;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.orm.entity.Company;
import com.kacofidoo.srm.orm.entity.User;
import com.kacofidoo.srm.orm.page.Page;

/**
 * @author Jeff.Tsai
 * 
 */
public interface CompanyService {

	Company load(long id) throws SrmException;

	Company queryByName(String companyName) throws SrmException;

	void register(Company company) throws SrmException;

	Page<Company> queryWithPage(int pageNo, int pageSize) throws SrmException;

	void delete(long id) throws SrmException;

}
