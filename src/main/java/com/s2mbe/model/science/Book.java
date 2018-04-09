package com.s2mbe.model.science;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@QueryEntity
@Document(collection = "scienceUnit")
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("volume", volume)
                .append("publisher", publisher)
                .toString();
    }
}
