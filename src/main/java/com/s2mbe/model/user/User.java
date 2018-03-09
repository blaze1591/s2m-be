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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<Cathedra> getCathedras() {
        return cathedras;
    }

    public void setCathedras(List<Cathedra> cathedras) {
        this.cathedras = cathedras;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNameUa() {
        return firstNameUa;
    }

    public void setFirstNameUa(String firstNameUa) {
        this.firstNameUa = firstNameUa;
    }

    public String getMiddleNameUa() {
        return middleNameUa;
    }

    public void setMiddleNameUa(String middleNameUa) {
        this.middleNameUa = middleNameUa;
    }

    public String getLastNameUa() {
        return lastNameUa;
    }

    public void setLastNameUa(String lastNameUa) {
        this.lastNameUa = lastNameUa;
    }

    public String getFirstNameRu() {
        return firstNameRu;
    }

    public void setFirstNameRu(String firstNameRu) {
        this.firstNameRu = firstNameRu;
    }

    public String getMiddleNameRu() {
        return middleNameRu;
    }

    public void setMiddleNameRu(String middleNameRu) {
        this.middleNameRu = middleNameRu;
    }

    public String getLastNameRu() {
        return lastNameRu;
    }

    public void setLastNameRu(String lastNameRu) {
        this.lastNameRu = lastNameRu;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getScienceDegree() {
        return scienceDegree;
    }

    public void setScienceDegree(String scienceDegree) {
        this.scienceDegree = scienceDegree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public String getGoogleScholar() {
        return googleScholar;
    }

    public void setGoogleScholar(String googleScholar) {
        this.googleScholar = googleScholar;
    }

    public String getBibtex() {
        return bibtex;
    }

    public void setBibtex(String bibtex) {
        this.bibtex = bibtex;
    }

    public String getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(String researcherId) {
        this.researcherId = researcherId;
    }

    public String getScopus() {
        return scopus;
    }

    public void setScopus(String scopus) {
        this.scopus = scopus;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public String getResearchGate() {
        return researchGate;
    }

    public void setResearchGate(String researchGate) {
        this.researchGate = researchGate;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public List<ScopusEntity> getScopusEntities() {
        return scopusEntities;
    }

    public void setScopusEntities(List<ScopusEntity> scopusEntities) {
        this.scopusEntities = scopusEntities;
    }

    public int getScopusCitationSumm() {
        return scopusCitationSumm;
    }

    public void setScopusCitationSumm(int scopusCitationSumm) {
        this.scopusCitationSumm = scopusCitationSumm;
    }

    public List<GoogleScholarEntity> getGoogleScholarEntities() {
        return googleScholarEntities;
    }

    public void setGoogleScholarEntities(List<GoogleScholarEntity> googleScholarEntities) {
        this.googleScholarEntities = googleScholarEntities;
    }

    public int getGoogleScholarCitationSumm() {
        return googleScholarCitationSumm;
    }

    public void setGoogleScholarCitationSumm(int googleScholarCitationSumm) {
        this.googleScholarCitationSumm = googleScholarCitationSumm;
    }

    public List<WebOfScienceEntity> getWebOfScienceEntities() {
        return webOfScienceEntities;
    }

    public void setWebOfScienceEntities(List<WebOfScienceEntity> webOfScienceEntities) {
        this.webOfScienceEntities = webOfScienceEntities;
    }

    public int getWebOfScienceCitationSumm() {
        return webOfScienceCitationSumm;
    }

    public void setWebOfScienceCitationSumm(int webOfScienceCitationSumm) {
        this.webOfScienceCitationSumm = webOfScienceCitationSumm;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String getRegistrationToken() {
        return registrationToken;
    }

    public void setRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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
