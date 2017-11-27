package com.s2mbe.repository;

import com.s2mbe.model.science.ScienceUnit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScienceUnitRepository extends MongoRepository<ScienceUnit, String> {
    List<ScienceUnit> findAllByUnitType(String unitType);
}
