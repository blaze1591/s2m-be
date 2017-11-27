package com.s2mbe.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.s2mbe.model.science.*;
import com.s2mbe.repository.ScienceUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScienceUnitServiceImpl implements ScienceUnitService {
    private final ObjectMapper MAPPER = new ObjectMapper();
    private static final Map<String, Class> types = ImmutableMap.<String, Class> builder()
            .put("Book", Book.class)
            .put("Chapter", Chapter.class)
            .put("Conference", Conference.class)
            .put("Journal", Journal.class)
            .put("Other", Other.class)
            .put("Patent", Patent.class)
            .put("Thesis", Thesis.class)
            .build();

    @Autowired
    ScienceUnitRepository scienceUnitRepository;

    @Override
    public List<ScienceUnit> findAll() {
        System.out.println(scienceUnitRepository.findAll().get(0).getClass());
        System.out.println(scienceUnitRepository.findAll().get(1).getClass());
        return scienceUnitRepository.findAll();
    }

    @Override
    public ScienceUnit save(Map<String,String> scienceUnitParams) {
        ScienceUnit scienceUnit = convertToPOJO(scienceUnitParams);
        return scienceUnitRepository.save(scienceUnit);
    }

    @Override
    public List<ScienceUnit> findAllByType(String unitType) {
        return null;
    }

    @SuppressWarnings("unchecked")
    private ScienceUnit convertToPOJO(Map<String, String> params) {
        String unitType = params.get("unitType");
        Class type = types.get(unitType);
        return (ScienceUnit) MAPPER.convertValue(params, type);
    }
}
