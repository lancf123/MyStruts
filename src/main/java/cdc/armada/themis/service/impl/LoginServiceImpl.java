package cdc.armada.themis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	/**
	 * get user name
	 * 
	 * @param user
	 *            user info
	 * @return user name
	 */
	public String selectUserName(UserEntity user) {
		System.out.println("startService");
		return loginMapper.selectUserName(user);
	}

}
