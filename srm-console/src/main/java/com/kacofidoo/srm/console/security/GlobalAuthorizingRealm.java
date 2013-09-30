package com.kacofidoo.srm.console.security;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.kacofidoo.srm.common.exception.SrmDaoException;
import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.User;

@Service("globalAuthorizingRealm")
public class GlobalAuthorizingRealm extends AuthorizingRealm {

	private static final Log log = LogFactory.getLog(GlobalAuthorizingRealm.class);

	@Inject
	private UserDao userDao;

	/**
	 * 登陆认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();

		// Null username is invalid
		if (StringUtils.isEmpty(username)) {
			throw new AccountException("Empty usernames are not allowed by this realm.");
		}

		AuthenticationInfo info = null;
		try {
			String password = getPasswordForUser(username);

			if (StringUtils.isEmpty(password)) {
				throw new UnknownAccountException("No account found for user [" + username + "]");
			}

			SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(username, password, getName());
			/**
			 * This (very bad) example uses the username as the salt in this sample app. DON'T DO THIS IN A REAL APP!
			 * 
			 * Salts should not be based on anything that a user could enter (attackers can exploit this). Instead they
			 * should ideally be cryptographically-strong randomly generated numbers.
			 */
			saInfo.setCredentialsSalt(ByteSource.Util.bytes(username));

			info = saInfo;

		} catch (SrmDaoException e) {
			final String message = "There was a SQL error while authenticating user [" + username + "]";
			if (log.isErrorEnabled()) {
				log.error(message, e);
			}

			// Rethrow any SQL errors as an authentication exception
			throw new AuthenticationException(message, e);
		}
		return info;
	}

	/**
	 * 查找密码
	 * 
	 * @param username
	 * @return
	 * @throws SrmDaoException
	 */
	private String getPasswordForUser(final String username) throws SrmDaoException {
		final User user = this.userDao.queryByPropertyForObject("name", username);
		return user.getPassword();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		principals.getRealmNames();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 获取用户信息的所有资料，如权限角色等.
		
//		info.setStringPermissions(权限集合);
//		info.setRoles(角色集合);
		
		return info;
	}
}