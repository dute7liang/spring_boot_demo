package com.duteliang.spring.shiro.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置类 <br/>
 *  官方推荐配置:<a>http://shiro.apache.org/spring.html</a>
 * @Auther: zl
 * @Date: 2018-9-28 16:58
 */
@Configuration
@Slf4j
public class ShiroConfig {

	/**
	 * 注入自定义 realm
	 */
	@Bean
	public MyRealm myRealm(){
		return new MyRealm();
	}

	/**
	 * 注入 SecurityManager
	 */
	@Bean
	public SecurityManager securityManager(MyRealm myRealm){
		DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myRealm);
		return securityManager;
	}

	/**
	 * 配置拦截器
	 */
	@Bean
	@ConditionalOnProperty
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 设置登录 url(没有登陆就跳转到这个链接) 由FormAuthenticationFilter 拦截器进行处理 authc
		shiroFilterFactoryBean.setLoginUrl("/login_page");
		// 设置登录成功url(不建议配置)
		shiroFilterFactoryBean.setSuccessUrl("/");
		// 设置无权限跳转url
		shiroFilterFactoryBean.setUnauthorizedUrl("/go");

		/**
		 * DefaultFilter 默认过滤器
		 */
		// 设置拦截器
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		//游客，开发权限
		filterChainDefinitionMap.put("/guest/**", "anon");
		//用户，需要角色权限 “user”
		filterChainDefinitionMap.put("/user/**", "roles[user]");
		//管理员，需要角色权限 “admin”
		filterChainDefinitionMap.put("/admin/**", "roles[admin]");

		//开放登陆接口
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/login_page", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");

		//其余接口一律拦截
		filterChainDefinitionMap.put("/**", "authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		log.debug("Shiro拦截器工厂类注入成功");
		return shiroFilterFactoryBean;
	}

}