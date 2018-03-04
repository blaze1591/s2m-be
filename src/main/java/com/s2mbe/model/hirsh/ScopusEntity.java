package com.s2mbe.model.hirsh;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class ScopusEntity extends HirshEntity {
    @Override
    public String toString() {
        return super.toString();
    }
}
