/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.service.impl;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.console.service.UserService;
import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Jeff.Tsai
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;


    /*
     * (non-Javadoc)
     *
     * @see com.kacofidoo.srm.console.service.UserService#getUserById(java.lang.String)
     */
    @Override
    public User getUserById(String id) throws SrmException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.kacofidoo.srm.console.service.UserService#getUserByName(java.lang.String)
     */
    @Override
    public User getUserByName(String username) throws SrmException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.kacofidoo.srm.console.service.UserService#deleteUserById(java.lang.String)
     */
    @Override
    public void deleteUserById(String id) throws SrmException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see com.kacofidoo.srm.console.service.UserService#deleteUserByName(java.lang.String)
     */
    @Override
    public void deleteUserByName(String name) throws SrmException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see com.kacofidoo.srm.console.service.UserService#queryWithPage(int, int)
     */
    @Override
    public void queryWithPage(int pageNo, int pageSize) throws SrmException {
        // TODO Auto-generated method stub

    }

    @Override
    @Transactional
    public void register(User user) throws SrmException {
        this.userDao.insert(user);
    }

}
