package com.duteliang.spring.shiro.controller;

import com.duteliang.spring.shiro.model.User;
import com.duteliang.spring.shiro.vo.Json;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Auther: zl
 * @Date: 2018-9-29 17:51
 */
@Controller
@Slf4j
public class ShiroController extends BaseController {

	private final static String LOGIN_PAGE = "html/login";

	@GetMapping(value = "login_page")
	public String loginPage(){
		return LOGIN_PAGE;
	}

	/**
	 * 登入
	 */
	@PostMapping(value = "login")
	@ResponseBody
	public Json login(User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return new Json(false,"登入失败！");
		}
		String name = user.getUserName();
		UsernamePasswordToken token = new UsernamePasswordToken(name,user.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		Json json = new Json();
		try {
			//在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			//每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			//所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			log.info("对用户[" + name + "]进行登录验证..验证开始");
			currentUser.login(token);
			log.info("对用户[" + name + "]进行登录验证..验证通过");
		} catch (UnknownAccountException uae) {
			log.info("对用户[" + name + "]进行登录验证..验证未通过,未知账户");
			json.setMsg("未知账户");
		} catch (IncorrectCredentialsException ice) {
			log.info("对用户[" + name + "]进行登录验证..验证未通过,错误的凭证");
			json.setMsg("密码错误");
		} catch (LockedAccountException lae) {
			log.info("对用户[" + name + "]进行登录验证..验证未通过,账户已锁定");
			json.setMsg("账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			log.info("对用户[" + name + "]进行登录验证..验证未通过,错误次数过多");
			json.setMsg("用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			log.info("对用户[" + name + "]进行登录验证..验证未通过",ae);
			json.setMsg("用户名或密码不正确");
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			log.info("用户[" + name + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
			json.setSuccess(true);
			return json;
		} else {
			token.clear();
			return json;
		}
	}

}
