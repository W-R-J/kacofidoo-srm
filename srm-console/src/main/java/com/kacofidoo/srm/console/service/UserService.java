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

    User getUserById(String id) throws SrmException;

    User getUserByName(String username) throws SrmException;

    void deleteUserById(String id) throws SrmException;

    void deleteUserByName(String name) throws SrmException;

    void queryWithPage(int pageNo, int pageSize) throws SrmException;

    void register(User user) throws SrmException;

}
