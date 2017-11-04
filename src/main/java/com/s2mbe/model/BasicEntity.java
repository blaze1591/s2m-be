package com.s2mbe.model;

import javax.persistence.Id;

public abstract class BasicEntity {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
