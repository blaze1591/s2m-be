package com.s2mbe.model.science;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Thesis extends ScienceUnit {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
