package com.s2mbe.model.science;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Book extends ScienceUnit {
    private String volume;
    private String publisher;

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
