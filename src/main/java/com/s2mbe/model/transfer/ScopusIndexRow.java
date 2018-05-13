package com.s2mbe.model.transfer;

import com.s2mbe.model.hirsh.ScopusEntity;

import java.util.List;

public interface ScopusIndexRow extends DashboardRow {
    List<ScopusEntity> getScopusEntities();

    default double getValue() {
        List<ScopusEntity> entities = this.getScopusEntities();
        return entities.get(entities.size() - 1).getIndex();
    }
}
