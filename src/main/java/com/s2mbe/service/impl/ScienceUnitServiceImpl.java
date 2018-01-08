package com.s2mbe.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.s2mbe.model.science.*;
import com.s2mbe.model.user.User;
import com.s2mbe.repository.ScienceUnitRepository;
import com.s2mbe.repository.UserRepository;
import com.s2mbe.service.ScienceUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScienceUnitServiceImpl implements ScienceUnitService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
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

    @Autowired
    UserRepository userRepository;

    @Override
    public List<ScienceUnit> findAll() {
        return scienceUnitRepository.findAll();
    }

    @Override
    public ScienceUnit findOne(String id) {
        if (!scienceUnitRepository.exists(id)) {
            throw new IllegalArgumentException("ScienceUnit with specified id, doesn't exist");
        }
        return scienceUnitRepository.findOne(id);
    }

    @Override
    public ScienceUnit save(Map<String,Object> scienceUnitParams) {
        ScienceUnit scienceUnit = convertToPOJO(scienceUnitParams);
        return scienceUnitRepository.save(scienceUnit);
    }

    @Override
    public ScienceUnit update(String id, Map<String, Object> scienceUnitParams) {
        if (!scienceUnitRepository.exists(id)) {
            throw new IllegalArgumentException("ScienceUnit with specified id, doesn't exist");
        }
        ScienceUnit scienceUnit = convertToPOJO(scienceUnitParams);
        return scienceUnitRepository.save(scienceUnit);
    }

    @Override
    public void delete(String id) {
        if (!scienceUnitRepository.exists(id)) {
            throw new IllegalArgumentException("ScienceUnit with specified id, doesn't exist");
        }
        scienceUnitRepository.delete(id);
    }

    @Override
    public List<ScienceUnit> findAllByType(String unitType) {
        return null;
    }

    @Override
    public List<ScienceUnit> findAllByUserId(String userId) {
        if (!userRepository.exists(userId)) {
            throw new IllegalArgumentException("ScienceUnits connected to specified userId, don't exist");
        }
        User user = new User();
        user.setId(userId);
        return scienceUnitRepository.findAllByUsersContains(user);
    }

    @SuppressWarnings("unchecked")
    private ScienceUnit convertToPOJO(Map<String, Object> params) {
        String unitType = (String) params.get("unitType");
        Class type = types.get(unitType);
        return (ScienceUnit) MAPPER.convertValue(params, type);
    }
}
