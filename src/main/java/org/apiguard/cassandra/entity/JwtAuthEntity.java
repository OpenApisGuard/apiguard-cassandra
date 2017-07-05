package org.apiguard.cassandra.entity;

import org.apiguard.entity.JwtAuth;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table("jwtAuth")
public class JwtAuthEntity extends BaseEntity implements JwtAuth {

    @PrimaryKey
    private String issuer;

    private String clientId;

    private String secret;

    private String reqUri;

    // nbf- identifies the time before which the JWT must not be accepted for processing.
    private boolean notBefore;

    // exp - identifies the expiration time on or after which the JWT must not be accepted for processing.
    private boolean expires;

    public JwtAuthEntity() {
    }

    public JwtAuthEntity(String id, Date creationDate, Date lastUpdateDate, String reqUri, String clientId,
                         String secret) {
        super(id, creationDate, lastUpdateDate);
        this.issuer = id;
        this.secret = secret;
        this.clientId = clientId;
        this.reqUri = reqUri;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getClientId() {
        return clientId;
    }

    public String getReqUri() {
        return reqUri;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public boolean isNotBefore() {
        return notBefore;
    }

    public void setNotBefore(boolean notBefore) {
        this.notBefore = notBefore;
    }

    public boolean isExpires() {
        return expires;
    }

    public void setExpires(boolean expires) {
        this.expires = expires;
    }
}
