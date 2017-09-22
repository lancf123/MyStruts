package cdc.armada.themis.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cdc.armada.themis.entity.UserEntity;

/**
 * @author cdc
 *
 */
@Repository
public interface LoginMapper {

    /**
     * @param user user info
     * @return user Id
     */
    String selectRoleId(UserEntity user);

    /**
     * get user name
     * 
     * @param user user
     * @return user name
     */
    String selectUserName(UserEntity user);

    public List<UserEntity> getAllData();
}
