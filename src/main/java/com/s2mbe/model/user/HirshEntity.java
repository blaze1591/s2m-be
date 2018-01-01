package com.s2mbe.model.user;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@Embeddable
public class HirshEntity {
    private double index;
    private Date indexDate;
}
