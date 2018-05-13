package com.s2mbe.model.transfer;

import com.s2mbe.model.hirsh.WebOfScienceEntity;

import java.util.List;

public interface WebOfScienceIndexRow extends DashboardRow {
    List<WebOfScienceEntity> getWebOfScienceEntities();

    default double getValue() {
        List<WebOfScienceEntity> entities = this.getWebOfScienceEntities();
        return entities.get(entities.size() - 1).getIndex();
    }
}
