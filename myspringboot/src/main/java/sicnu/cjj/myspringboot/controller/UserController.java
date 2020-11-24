package sicnu.cjj.myspringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sicnu.cjj.myspringboot.entity.LoginInfo;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.result.Result;
import sicnu.cjj.myspringboot.result.ResultGenerator;
import sicnu.cjj.myspringboot.service.RoleService;
import sicnu.cjj.myspringboot.service.UserService;
import sicnu.cjj.myspringboot.service.impl.LoginServiceImpl;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Resource
    LoginServiceImpl loginServiceImpl;
    @RequestMapping("login")
    public Result getUser(@RequestBody LinkedHashMap<String,String> params , Model model){
        //String account, String password, Model model
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(params.get("account") ,params.get("password"));
        //UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        System.out.println("usertokende 的值"+token.getUsername());

        try{
            subject.login(token); //执行登录方法，如果没有异常就ok,执行了UserRealm的认证方法
            Session session = subject.getSession();
            session.setAttribute("account",params.get("account"));
            LoginInfo loginInfo= loginServiceImpl.getLoginInfo();
            Result result=ResultGenerator.genSuccessResult(loginInfo);
            return result;
        }catch(UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultGenerator.genFailResult(message);
        }catch(IncorrectCredentialsException e){
            model.addAttribute("msd","cs");
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultGenerator.genFailResult(message);
        }


    }

    @RequestMapping("add")
    public User Add(String user){
        System.out.println("执行了add函数");
        return userService.getUser(user);
    }
    @RequestMapping("tologin")
    public String Tologin(){
        return "没有权限login";
    }
}
