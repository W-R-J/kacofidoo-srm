package com.kacofidoo.srm.console.security;

import java.util.HashSet;
import java.util.Set;

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
import org.springframework.stereotype.Service;

import com.kacofidoo.srm.orm.dao.UserDao;
import com.kacofidoo.srm.orm.entity.Permission;
import com.kacofidoo.srm.orm.entity.Role;
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
			if (log.isWarnEnabled()) {
				log.warn("login username is blank.");
			}
			throw new AccountException("Empty usernames are not allowed by this realm.");
		}

		User user = this.userDao.queryByPropertyForObject("name", username);
		if (user == null) {
			final String errmsg = "No account found for user [" + username + "]";
			if (log.isWarnEnabled()) {
				log.warn(errmsg);
			}
			throw new UnknownAccountException(errmsg);
		}
		String password = user.getPassword();
		SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(user.getId(), password, getName());
		return saInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Long userId = (Long) principals.fromRealm(getName()).iterator().next();
		User user = this.userDao.load(userId);
		if (user == null) {
			return null;
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> permissions = null;
		for (Role role : user.getRoles()) {
			info.addRole(role.getName());
			permissions = new HashSet<String>();
			for (Permission p : role.getPermissions()) {
				permissions.add(p.getName());
			}
			info.addStringPermissions(permissions);
		}
		return info;
	}
}