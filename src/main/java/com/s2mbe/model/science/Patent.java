package com.s2mbe.model.science;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Patent extends ScienceUnit {
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
