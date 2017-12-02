package com.s2mbe.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.s2mbe.model.BasicEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User extends BasicEntity {
    private String photo;

    // TODO: Create class of cathedra type, and fill and take all this data from it
    private String institute;
    private String faculty;
    private String cathedra;

    private String firstName;
    private String middleName;
    private String lastName;

    private String firstNameUa;
    private String middleNameUa;
    private String lastNameUa;

    // TODO: make enums maybe
    private List<String> academicTitles;
    private List<String> scienceDegrees;

    private String post;

    private String email;
    private String address;
    private String telephone;

    private String orcid;
    private String googleScholar;
    private String bibtex;
    private String researcherId;
    private String scopus;
    private String academia;
    private String researchGate;

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
