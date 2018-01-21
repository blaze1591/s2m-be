package com.s2mbe.model.science;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("note", note)
                .toString();
    }
}
