package com.s2mbe.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryEntity;
import com.s2mbe.model.BasicEntity;
import com.s2mbe.model.hirsh.GoogleScholarEntity;
import com.s2mbe.model.hirsh.ScopusEntity;
import com.s2mbe.model.hirsh.WebOfScienceEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@QueryEntity
@Document
public class User extends BasicEntity {
    private String photo;

    // TODO: Create class of cathedra type, and fill and take all this data from it
    private String institute;
    private String faculty;
    private List<Cathedra> cathedras;

    private String firstName;
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
    private String academia = "ОНАХТ";
    private String researchGate;
    private String linkedIn;

    private List<ScopusEntity> scopusEntities;
    private int scopusCitationSumm;
    private List<GoogleScholarEntity> googleScholarEntities;
    private int googleScholarCitationSumm;
    private List<WebOfScienceEntity> webOfScienceEntities;
    private int webOfScienceCitationSumm;

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

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public List<ScopusEntity> getScopusEntities() {
        return scopusEntities;
    }

    public List<GoogleScholarEntity> getGoogleScholarEntities() {
        return googleScholarEntities;
    }

    public List<WebOfScienceEntity> getWebOfScienceEntities() {
        return webOfScienceEntities;
    }

    public void setScopusCitationSumm(int scopusCitationSumm) {
        this.scopusCitationSumm = scopusCitationSumm;
    }

    public void setGoogleScholarCitationSumm(int googleScholarCitationSumm) {
        this.googleScholarCitationSumm = googleScholarCitationSumm;
    }

    public void setWebOfScienceCitationSumm(int webOfScienceCitationSumm) {
        this.webOfScienceCitationSumm = webOfScienceCitationSumm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("photo", photo)
                .append("institute", institute)
                .append("faculty", faculty)
                .append("cathedras", cathedras)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("firstNameUa", firstNameUa)
                .append("middleNameUa", middleNameUa)
                .append("lastNameUa", lastNameUa)
                .append("firstNameRu", firstNameRu)
                .append("middleNameRu", middleNameRu)
                .append("lastNameRu", lastNameRu)
                .append("academicTitle", academicTitle)
                .append("scienceDegree", scienceDegree)
                .append("email", email)
                .append("address", address)
                .append("telephone", telephone)
                .append("orcid", orcid)
                .append("googleScholar", googleScholar)
                .append("bibtex", bibtex)
                .append("researcherId", researcherId)
                .append("scopus", scopus)
                .append("academia", academia)
                .append("researchGate", researchGate)
                .append("linkedIn", linkedIn)
                .append("scopusEntities", scopusEntities)
                .append("scopusCitationSumm", scopusCitationSumm)
                .append("googleScholarEntities", googleScholarEntities)
                .append("googleScholarCitationSumm", googleScholarCitationSumm)
                .append("webOfScienceEntities", webOfScienceEntities)
                .append("webOfScienceCitationSumm", webOfScienceCitationSumm)
                .append("birthDate", birthDate)
                .append("registrationDate", registrationDate)
                .append("credentials", credentials)
                .append("registrationToken", registrationToken)
                .append("active", active)
                .append("deleted", deleted)
                .toString();
    }
}
