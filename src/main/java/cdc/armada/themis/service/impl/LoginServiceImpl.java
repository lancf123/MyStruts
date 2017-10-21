package cdc.armada.themis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cdc.armada.noah.common.CommonConst;
import cdc.armada.themis.entity.UserEntity;
import cdc.armada.themis.mapper.LoginMapper;
import cdc.armada.themis.service.LoginService;

/**
 * @author cdc
 *
 */
@Service("loginService")
@EnableTransactionManagement
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

	/**
	 * mybatis mapper
	 */
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private Environment env;

	/**
	 * get user name
	 * 
	 * @param user
	 *            user info
	 * @return user name
	 */
	public String selectUserName(UserEntity user) {
		System.out.println("startService");
		
		String code = env.getProperty(CommonConst.SYSTEM_ERROR_CODE);
		return "abc";
		//return loginMapper.selectUserName(user);
	}

}
