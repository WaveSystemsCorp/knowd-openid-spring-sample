package com.wave.openid.springsample;

import org.hibernate.annotations.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.io.Serializable;
import java.util.UUID;

/**
 * User entity object
 */
@javax.persistence.Entity
@org.hibernate.annotations.Entity
@Table(name = "user")
public class User
    implements Serializable, UserDetails
{

    @Id
    @Column(nullable = false, name = "id", length = 40)
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false, name = "password")
    private String password;

    @Index(name="idx_email")
    @Column(nullable = false, name = "email")
    private String email = null;

    @Index(name="idx_username")
    @Column(nullable = false, name = "username")
    private String username = null;

    @Column(nullable = false, name = "enabled")
    private boolean enabled = true;

    @Column(nullable = false, name = "accountnonexpired")
    private boolean accountNonExpired = true;

    @Column(nullable = false, name = "credentialsnonexpired")
    private boolean credentialsNonExpired = true;

    @Column(nullable = false, name = "accountnonlocked")
    private boolean accountNonLocked = true;

    @Column(nullable = false, name = "accountconfirmed")
    private boolean accountConfirmed = false;

    @Column(nullable = false, name = "last_update")
    private Date lastUpdate = new Date();

    @Column(nullable = true, name = "last_ip")
    private String lastIp = null;

    @Column(nullable = true, name = "last_user_agent")
    private String userAgent = null;

    @Column(nullable = false, name = "create_time")
    private Date createTime = new Date();

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // For testing only lets assume everyone will get authority ROLE_USER
        return new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", accountNonExpired=" + accountNonExpired +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", accountConfirmed=" + accountConfirmed +
                ", lastUpdate=" + lastUpdate +
                ", lastIp='" + lastIp + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired()
    {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired)
    {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired()
    {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired)
    {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonLocked()
    {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked)
    {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isAccountConfirmed()
    {
        return accountConfirmed;
    }

    public void setAccountConfirmed(boolean accountConfirmed)
    {
        this.accountConfirmed = accountConfirmed;
    }

    public Date getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    public String getLastIp()
    {
        return lastIp;
    }

    public void setLastIp(String lastIp)
    {
        this.lastIp = lastIp;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}