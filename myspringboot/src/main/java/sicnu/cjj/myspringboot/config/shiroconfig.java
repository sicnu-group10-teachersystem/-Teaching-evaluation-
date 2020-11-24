package sicnu.cjj.myspringboot.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class shiroconfig {

    //ShiroFilterfactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("desecurityManager") DefaultWebSecurityManager defaultWebSecurityManager ){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            user:必须拥有  记住我 功能才能用
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        //拦截
        Map<String, String> filterMap=new LinkedHashMap<>();

        //user/add能被所有人访问
        //filterMap.put("/user/add","anon");

        //拥有某个权限才能访问，被拦截会在UserRealm中执行授权函数,如果权限被授予，那么用户就拥有此权限
        filterMap.put("/user/add","perms[user:add]");

        //必须认证之后才能访问（UserRealm的认证函数）
        //filterMap.put("/user/login","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //如果没有权限，跳转到login页面，tologin是为了跳转页面
        bean.setLoginUrl("/user/tologin");
        //未授权页面
        //bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    //DafaultWebSecurityManager：2
    @Bean(name="desecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm 对象，需要自定义类：1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect：用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}
