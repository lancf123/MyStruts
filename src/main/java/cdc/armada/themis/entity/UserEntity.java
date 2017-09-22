package cdc.armada.themis.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author cdc
 *
 */
@XmlRootElement(name = "User")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 2686725063713793784L;

    /**
     * userId
     */
    @Size(min=3, message="username length 3-20")
    private String userId;

    /**
     * userName
     */
    private String userName;

    /**
     * password
     */
    @Size(min=3, message="password length 3-20")
    private String password;

    /**
     * lockFlag
     */
    private String lockFlag;

    /**
     * constructor
     */
    public UserEntity() {
        super();
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the lockFlag
     */
    public String getLockFlag() {
        return lockFlag;
    }

    /**
     * @param lockFlag
     *            the lockFlag to set
     */
    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

}
