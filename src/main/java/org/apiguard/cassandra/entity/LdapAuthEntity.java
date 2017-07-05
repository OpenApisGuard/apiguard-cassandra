package org.apiguard.cassandra.entity;

import org.apiguard.entity.LdapAuth;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table("ldapAuth")
public class LdapAuthEntity extends BaseEntity implements LdapAuth {

    @PrimaryKey
    private LdapAuthId pk;

    private String ldapUrl;

    private String adminDn;

    private String adminPassword;

    private String userBase;

    private String userAttr;

    private Integer cacheExpireInSecond;

    private String token;

    private Date lastLoginDate;

    public LdapAuthEntity() {
    }

    public LdapAuthEntity(String id, Date creationDate, Date lastUpdateDate, String reqUri, String clientId, String ldapUrl,
                          String adminDn, String adminPassword, String userBase, String userAttr, Integer cacheExpireInSecond) {
        super(id, creationDate, lastUpdateDate);
        pk = new LdapAuthId(reqUri, clientId);
        this.ldapUrl = ldapUrl;
        this.adminDn = adminDn;
        this.adminPassword = adminPassword;
        this.userBase = userBase;
        this.userAttr = userAttr;
        this.cacheExpireInSecond = cacheExpireInSecond;
    }

    public LdapAuthId getPk() {
        return pk;
    }

    public String getClientId() {
        return pk.getClientId();
    }

    public String getReqUri() {
        return pk.getReqUri();
    }

    public String getLdapUrl() {
        return ldapUrl;
    }

    public String getAdminDn() {
        return adminDn;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getUserBase() {
        return userBase;
    }

    public String getUserAttr() {
        return userAttr;
    }

    public Integer getCacheExpireInSecond() {
        return cacheExpireInSecond;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
