/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.service;

import com.kacofidoo.srm.orm.entity.User;

/**
 * @author Jeff.Tsai
 * 
 */
public interface UserService {

	User getUserById(String id);

	User getUserByName(String username);

	void deleteUserById(String id);

	void deleteUserByName(String name);

	void queryWithPage(int pageNo, int pageSize);
	
}
