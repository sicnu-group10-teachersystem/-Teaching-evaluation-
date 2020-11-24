package sicnu.cjj.myspringboot.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import sicnu.cjj.myspringboot.entity.Authority;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.mapper.AuthorityMapper;
import sicnu.cjj.myspringboot.mapper.RoleMapper;
import sicnu.cjj.myspringboot.service.RoleService;
import sicnu.cjj.myspringboot.service.UserService;

import java.util.List;

//自定义UserRealm   只有认证之后才能进行授权操作
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    AuthorityMapper authorityMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行力----------授权函数");
        //给用户授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        //拿到当前登录的这个对象
        Subject subject=SecurityUtils.getSubject();
        User user =(User)subject.getPrincipal();
        int role_id =roleService.selectrolebyuser(user.getUser_id());
        System.out.println("roleid未++++++++++"+role_id);

        List<Integer> auth_id = authorityMapper.selectauthidbyrole(role_id);

        for(int i :auth_id){
            Authority authority=authorityMapper.selectauthbyid(i);
            System.out.println("我有的权限++++++++++"+authority.getAuthority_name());
            info.addStringPermission(authority.getAuthority_name());
        }


        //info.addObjectPermissions(current.getP);

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名，密码，数据库取
        System.out.println("执行力----------认证函数");


        UsernamePasswordToken usertoken=(UsernamePasswordToken) token;

        //连接真实数据库
        User user =userService.getUser(usertoken.getUsername());


        if(user==null){
            return null;//
        }
        //MD5不可逆  MD5颜值加密
        //密码认证，shiro做
        //return new SimpleAuthenticationInfo("",user.getPassword(),"");
        //通过principal将用户传给授权函数
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
