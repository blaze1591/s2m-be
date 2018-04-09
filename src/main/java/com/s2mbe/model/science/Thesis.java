package com.s2mbe.model.science;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@QueryEntity
@Document(collection = "scienceUnit")
public class Thesis extends ScienceUnit {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("school", school)
                .toString();
    }
}
