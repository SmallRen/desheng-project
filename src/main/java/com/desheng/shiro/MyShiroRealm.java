package com.desheng.shiro;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.desheng.mapper.PermissionMapper;
import com.desheng.mapper.RoleMapper;
import com.desheng.mapper.UserMapper;
import com.desheng.pojo.User;
import com.desheng.pojo.UserExample;

import java.lang.reflect.InvocationTargetException;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;

	private static Logger log = LoggerFactory.getLogger(MyShiroRealm.class);

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
		String username = utoken.getUsername();
		// String password = new String(utoken.getPassword());
		// 查出是否有此用户
		UserExample u = new UserExample();
		u.createCriteria().andUsernameEqualTo(username);
		User user = userMapper.selectByExampleOne(u);
		if (user.getStatus() != 1) {
			throw new LockedAccountException("用户无效");
		}
		// 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),
				ByteSource.Util.bytes(user.getSalt()), this.getName());

		return info;
	}

	// 授权,只有成功通过 doGetAuthenticationInfo方法的认证后才会执行。
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		log.info("只会加载一次授权");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = new User();
		Object principal = principalCollection.getPrimaryPrincipal();
		try {
			BeanUtils.copyProperties(user,principal);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		Integer userId = user.getId();
		roleMapper.queryRoleByUid(userId).stream().forEach(role -> {
			authorizationInfo.addRole(role.getName());
			permissionMapper.queryPermByRid(role.getId()).stream().forEach(permission -> {
				authorizationInfo.addStringPermission(permission.getPerms());
			});
		});
		return authorizationInfo;

	}


	/**
	 * 重写方法,清除当前用户的的 授权缓存
	 * @param principals
	 */
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 重写方法，清除当前用户的 认证缓存
	 * @param principals
	 */
	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	/**
	 * 自定义方法：清除所有 授权缓存
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	/**
	 * 自定义方法：清除所有 认证缓存
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	/**
	 * 自定义方法：清除所有的  认证缓存  和 授权缓存
	 */
	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}
