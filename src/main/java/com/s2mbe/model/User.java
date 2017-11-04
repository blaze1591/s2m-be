package com.s2mbe.model;

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


}
