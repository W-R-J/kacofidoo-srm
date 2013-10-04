/**
 * 
 */
package com.kacofidoo.srm.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kacofidoo.srm.orm.dao.RoleDao;
import com.kacofidoo.srm.orm.entity.Role;
import com.kacofidoo.srm.orm.utils.DaoSupportImpl;

/**
 * @author weiwei.cai
 * 
 */
@Repository("roleDao")
public class RoleDaoImpl extends DaoSupportImpl<Role> implements RoleDao {

}
