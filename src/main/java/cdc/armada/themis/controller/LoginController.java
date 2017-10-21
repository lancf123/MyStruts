package cdc.armada.themis.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cdc.armada.noah.common.AbstractComponent;
import cdc.armada.noah.common.CommonConst;
import cdc.armada.themis.entity.UserEntity;
import cdc.armada.themis.service.LoginService;

/**
 * @author cdc
 */
@RestController
@RequestMapping("/login")
public class LoginController extends AbstractComponent {

	/**
	 * server Controller service
	 */
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private Environment env;

	/**
	 * 根据用户ID密码判断登陆是否成功，同时获得用户名
	 * 
	 * @param user
	 *            登陆的角色信息
	 * @param response
	 *            response
	 * @return 用户名
	 * @throws Exception
	 *             Exception
	 */
	@RequestMapping(value = "/loginToMenu", method = RequestMethod.POST)
	@ResponseBody
	public String loginToMenu(@RequestBody UserEntity user, HttpServletResponse response) {

		String code = env.getProperty(CommonConst.SYSTEM_ERROR_CODE);
		getLogger().info("LoginRestController loginToMenu start");
		String name = loginService.selectUserName(user);
		getLogger().info("LoginRestController loginToMenu end");
		return name;
	}
}
