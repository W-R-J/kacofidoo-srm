/**
 * 
 */
package com.kacofidoo.srm.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.User;
import com.kacofidoo.srm.orm.utils.DaoSupportImpl;

/**
 * @author weiwei.cai
 * 
 */
@Repository("userDao")
public class UserDaoImpl extends DaoSupportImpl<User> implements UserDao {

}
