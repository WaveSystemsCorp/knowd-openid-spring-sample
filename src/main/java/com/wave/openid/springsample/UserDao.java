package com.wave.openid.springsample;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * User DAO service object - provides database access to User entity, extends HibernateDaoBase
 */
@Component
@EnableTransactionManagement
public class UserDao
    extends HibernateDaoBase<User>
{
    public UserDao()
    {
        setClazz( User.class );
    }

}
