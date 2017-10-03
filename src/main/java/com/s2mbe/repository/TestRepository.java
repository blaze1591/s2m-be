package com.s2mbe.repository;

import com.s2mbe.model.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends MongoRepository<TestEntity, String> {
    TestEntity findByFirstName(String firstName);
    List<TestEntity> findAllByFirstName(String firstName);
}
