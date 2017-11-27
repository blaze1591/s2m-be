package com.s2mbe.service;

import com.s2mbe.model.science.ScienceUnit;

import java.util.List;
import java.util.Map;

public interface ScienceUnitService {
    ScienceUnit save(Map<String, String> scienceUnitParams);
    List<ScienceUnit> findAll();
    List<ScienceUnit> findAllByType(String unitType);
}
