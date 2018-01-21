package com.s2mbe.model.science;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;

@Data
@Entity
public class Other extends ScienceUnit {
    private String journal;
    private String number;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("journal", journal)
                .append("number", number)
                .toString();
    }
}
