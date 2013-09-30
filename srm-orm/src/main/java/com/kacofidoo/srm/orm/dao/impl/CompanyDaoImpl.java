/**
 * 
 */
package com.kacofidoo.srm.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kacofidoo.srm.orm.dao.CompanyDao;
import com.kacofidoo.srm.orm.entity.Company;
import com.kacofidoo.srm.orm.utils.DaoSupportImpl;

/**
 * @author weiwei.cai
 * 
 */
@Repository("companyDao")
public class CompanyDaoImpl extends DaoSupportImpl<Company> implements CompanyDao {

}
