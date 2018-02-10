package com.s2mbe.model.science;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@QueryEntity
@Document
public class Journal extends ScienceUnit {
    private String journal;
    private String volume;
    private String number;
    private String pages;
    private String publisher;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("journal", journal)
                .append("volume", volume)
                .append("number", number)
                .append("pages", pages)
                .append("publisher", publisher)
                .toString();
    }
}
