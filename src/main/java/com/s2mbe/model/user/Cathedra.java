package com.s2mbe.model.user;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Cathedra {
    private String name;
    private String post;
    private boolean key;
}