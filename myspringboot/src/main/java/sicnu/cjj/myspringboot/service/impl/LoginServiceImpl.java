package sicnu.cjj.myspringboot.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.entity.Authority;
import sicnu.cjj.myspringboot.entity.LoginInfo;
import sicnu.cjj.myspringboot.entity.Role;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.service.AuthorityService;
import sicnu.cjj.myspringboot.service.RoleService;
import sicnu.cjj.myspringboot.service.UserService;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    AuthorityService authorityService;

    public  LoginInfo getLoginInfo(){
        List<String> roles=new ArrayList<String>() ;

        List<String> authorities=new ArrayList<String>();
        //查询有哪些角色名(通过用户名查角色名）
        //int role_id =roleService.selectrolebyuser(account);
        Subject subject = SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();
        int role_id =roleService.selectrolebyuser(user.getUser_id());
        //通过角色id查询到角色名
        String role_name =roleService.selectnamebyroleid(role_id);
        roles.add(role_name);
        List<Integer> auth_id = authorityService.selectauthidbyrole(role_id);

        for(int i :auth_id){
            Authority authority=authorityService.selectauthbyid(i);
            System.out.println("我有的权限++++++++++"+authority.getAuthority_name());
            authorities.add(authority.getAuthority_name());
        }
        LoginInfo loginInfo=new LoginInfo(roles,authorities);
        return loginInfo;
    }
}
