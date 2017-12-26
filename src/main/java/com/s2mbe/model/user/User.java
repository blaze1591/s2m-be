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
    private List<Cathedra> cathedras;

    private String firstName;
    private String middleName;
    private String lastName;

    private String firstNameUa;
    private String middleNameUa;
    private String lastNameUa;

    private String firstNameRu;
    private String middleNameRu;
    private String lastNameRu;

    // TODO: make enums maybe, or not
    private String academicTitle;
    private String scienceDegree;

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

    private double hirshScholar;
    private double hirshScopus;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
