package com.s2mbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class User extends BasicEntity {
    private String firstName;
    private String middleName;
    private String lastName;

    private String email;
    private String address;
    private String telephone;

    private Date birthDate;
    private Date registrationDate;

    private Credentials credentials;

    @JsonIgnore
    private String registrationToken;
    private Boolean active;

    private Boolean deleted;

    public String getEmail() {
        return email;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getRegistrationToken() {
        return registrationToken;
    }

    public void setRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
