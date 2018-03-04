package com.s2mbe.model.hirsh;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public abstract class HirshEntity {
    private double index;
    private Date date;
    private int citationCount;
    private int documentCount;

    public int getCitationCount() {
        return citationCount;
    }

    public Date getDate() {
        return date;
    }

    public double getIndex() {
        return index;
    }

    public int getDocumentCount() {
        return documentCount;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCitationCount(int citationCount) {
        this.citationCount = citationCount;
    }

    public void setDocumentCount(int documentCount) {
        this.documentCount = documentCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("index", index)
                .append("date", date)
                .append("citationCount", citationCount)
                .append("documentCount", documentCount)
                .toString();
    }
}
