package com.s2mbe.model.transfer;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserReportDTO {
    private String name;
    private String nameUa;
    private String title;
    private String googleScholarLink;
    private String orsidLink;
    private String researcherLink;
    private String scopusHIndex;
    private String scopusDocumentCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoogleScholarLink() {
        return googleScholarLink;
    }

    public void setGoogleScholarLink(String googleScholarLink) {
        this.googleScholarLink = googleScholarLink;
    }

    public String getOrsidLink() {
        return orsidLink;
    }

    public void setOrsidLink(String orsidLink) {
        this.orsidLink = orsidLink;
    }

    public String getResearcherLink() {
        return researcherLink;
    }

    public void setResearcherLink(String researcherLink) {
        this.researcherLink = researcherLink;
    }

    public String getNameUa() {
        return nameUa;
    }

    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }

    public String getScopusHIndex() {
        return scopusHIndex;
    }

    public void setScopusHIndex(String scopusHIndex) {
        this.scopusHIndex = scopusHIndex;
    }

    public String getScopusDocumentCount() {
        return scopusDocumentCount;
    }

    public void setScopusDocumentCount(String scopusDocumentCount) {
        this.scopusDocumentCount = scopusDocumentCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("title", title)
                .append("googleScholarLink", googleScholarLink)
                .append("orsidLink", orsidLink)
                .append("researcherLink", researcherLink)
                .append("scopusHIndex", scopusHIndex)
                .append("scopusDocumentCount", scopusDocumentCount)
                .toString();
    }
}
