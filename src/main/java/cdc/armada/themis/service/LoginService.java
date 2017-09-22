package cdc.armada.themis.service;

import cdc.armada.themis.entity.UserEntity;

/**
 * service interface
 * 
 * @author cdc
 *
 */
public interface LoginService {

	/**
	 * get user name
	 * 
	 * @param user
	 *            user info
	 * @return user name
	 */
	String selectUserName(UserEntity user);

}
