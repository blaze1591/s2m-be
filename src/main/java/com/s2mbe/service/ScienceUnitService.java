package com.s2mbe.service;

import com.s2mbe.model.science.ScienceUnit;

import java.util.List;
import java.util.Map;

public interface ScienceUnitService {
    ScienceUnit save(Map<String, Object> scienceUnitParams);
    List<ScienceUnit> bulkSave(List<String> userIds, List<Map<String, Object>> listOfParams);
    ScienceUnit update(String id, Map<String, Object> scienceUnitParams);
    void delete(String id);
    List<ScienceUnit> findAll();
    ScienceUnit findOne(String id);
    List<ScienceUnit> findAllByType(String unitType);
    List<ScienceUnit> findAllByUserId(String userId);
}
