package com.s2mbe.repository;

import com.s2mbe.model.science.ScienceUnit;
import com.s2mbe.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScienceUnitRepository extends MongoRepository<ScienceUnit, String> {
    List<ScienceUnit> findAllByUnitType(String unitType);
    List<ScienceUnit> findAllByUsersContains(User user);
}
