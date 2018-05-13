package com.s2mbe.model.transfer;

import com.s2mbe.model.hirsh.GoogleScholarEntity;

import java.util.List;

public interface GoogleScholarIndexRow extends DashboardRow {

    List<GoogleScholarEntity> getGoogleScholarEntities();

    default double getValue() {
        List<GoogleScholarEntity> entities = this.getGoogleScholarEntities();
        return entities.get(entities.size() - 1).getIndex();
    }

}
