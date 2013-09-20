/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.service;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.orm.entity.User;

/**
 * @author Jeff.Tsai
 */
public interface UserService {

	User load(long id) throws SrmException;

	User load(String username) throws SrmException;

	void deleteUserById(long id) throws SrmException;

	void deleteUserByName(String name) throws SrmException;

	void queryWithPage(int pageNo, int pageSize, String username, Long companyId) throws SrmException;

	void register(User user) throws SrmException;

}
