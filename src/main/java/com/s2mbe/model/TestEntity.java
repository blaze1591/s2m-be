package com.s2mbe.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Data
@Entity
public class TestEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
}
