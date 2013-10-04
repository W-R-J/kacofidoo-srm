/**
 * 
 */
package com.kacofidoo.srm.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kacofidoo.srm.orm.dao.PermissionDao;
import com.kacofidoo.srm.orm.entity.Permission;
import com.kacofidoo.srm.orm.utils.DaoSupportImpl;

/**
 * @author weiwei.cai
 * 
 */
@Repository("permissionDao")
public class PermissionDaoImpl extends DaoSupportImpl<Permission> implements PermissionDao {

}
