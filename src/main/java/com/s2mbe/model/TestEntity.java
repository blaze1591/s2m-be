package com.s2mbe.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@QueryEntity
@Document
public class TestEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
}
