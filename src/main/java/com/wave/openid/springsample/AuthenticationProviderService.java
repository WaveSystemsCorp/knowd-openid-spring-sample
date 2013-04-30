package com.wave.openid.springsample;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * AuthenticationProviderService provides services for user authentication, based on username provided
 * This service provider would work with OpenID / DeviceID as well as standard username / password authentication
 */
public class AuthenticationProviderService
    implements UserDetailsService
{
    private static final Logger log = Logger.getLogger(AuthenticationProviderService.class);
    public static final String USERNAME_FIELD = "username";

    @Autowired
    HibernateDaoBase<User> userDao = null;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
    {
        List<User> userList = userDao.getListByField( USERNAME_FIELD, username );
        Date now = new Date();
        User foundUser = null;
        if (userList.size() > 0)
        {
            foundUser = userList.get(0);
            foundUser.setLastUpdate( now );
            userDao.update( foundUser );
        }
        else
        {
            foundUser = new User();
            foundUser.setUsername( username );
            foundUser.setPassword( "" );
            foundUser.setEmail( "" );
            foundUser.setLastUpdate( now );
            userDao.create( foundUser );
            userList = userDao.getListByField( USERNAME_FIELD, username );
            if (userList.size() > 0)
            {
                foundUser = userList.get(0);
            }
        }
        if (foundUser == null)
        {
            throw new CoreDaoException("Unable to create user entry");
        }
        return foundUser;
    }
}
