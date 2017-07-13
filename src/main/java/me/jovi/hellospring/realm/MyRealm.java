package me.jovi.hellospring.realm;

import me.jovi.hellospring.entity.User;
import me.jovi.hellospring.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by joyce on 2017/6/27.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(username));
        /*authorizationInfo.setStringPermissions(userService.findPermissions(username));
        System.out.println(userService.findPermissions(username));*/
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        User user = userService.getUserByLoginName(username);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        return new SimpleAuthenticationInfo(
                user.getLoginName(), //用户名
                user.getPassword(), //密码
                //ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName() //realm name
        );
    }
}
