/**
 * 
 */
package com.kacofidoo.srm.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kacofidoo.srm.orm.dao.DataDicDao;
import com.kacofidoo.srm.orm.entity.DataDic;

/**
 * @author weiwei.cai
 * 
 */
@Repository("dataDicDao")
public class DataDicDaoImpl extends DaoSupportImpl<DataDic> implements DataDicDao {

	/**
	 * 
	 */
	public DataDicDaoImpl() {
		super();
	}

}
