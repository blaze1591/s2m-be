package com.s2mbe.model.user;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@Embeddable
public class HirshEntity {
    private double indexScopus;
    private double indexScholar;
    private Date indexDate;
    private int citationCount;
    private int docCount;

    public int getCitationCount() {
        return citationCount;
    }

    public Date getIndexDate() {
        return indexDate;
    }

    public double getIndexScopus() {
        return indexScopus;
    }

    public double getIndexScholar() {
        return indexScholar;
    }

    public int getDocCount() {
        return docCount;
    }
}
