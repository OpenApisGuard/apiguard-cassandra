package org.apiguard.cassandra.entity;

import org.apiguard.entity.SignatureAuth;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table("signatureAuth")
public class SignatureAuthEntity extends BaseEntity implements SignatureAuth {

    @PrimaryKey
    private SignatureAuthId pk;

    private String secret;

    public SignatureAuthEntity() {
    }

    public SignatureAuthEntity(String id, Date creationDate, Date lastUpdateDate, String reqUri, String clientId, String clientAlias,
                               String secret) {
        super(id, creationDate, lastUpdateDate);
        pk = new SignatureAuthId(reqUri, clientId, clientAlias);
        this.secret = secret;
    }

    public SignatureAuthId getPk() {
        return pk;
    }

    public void setPk(SignatureAuthId pk) {
        this.pk = pk;
    }

    public String getClientId() {
        return pk.getClientId();
    }

    public String getReqUri() {
        return pk.getReqUri();
    }

    public String getClientAlias() {
        return pk.getClientAlias();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
