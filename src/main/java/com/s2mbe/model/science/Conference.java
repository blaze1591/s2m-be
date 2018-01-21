package com.s2mbe.model.science;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;

@Data
@Entity
public class Conference extends ScienceUnit {
    private String bookTitle;
    private String volume;
    private String number;
    private String pages;
    private String organization;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("bookTitle", bookTitle)
                .append("volume", volume)
                .append("number", number)
                .append("pages", pages)
                .append("organization", organization)
                .toString();
    }
}
