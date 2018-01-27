package com.s2mbe.model.transfer;

import com.s2mbe.model.user.HirshEntity;

import java.util.List;

public interface DashboardRow {
    String getPhoto();

    String getFirstNameUa();

    String getMiddleNameUa();

    String getLastNameUa();

    List<HirshEntity> getHirshCollection();

    default String getName() {
        return getLastNameUa() + " " + getFirstNameUa() + " " + getMiddleNameUa();
    }

    default int getValue() {
        int value = 0;
        for (HirshEntity hEntity : getHirshCollection()) {
            value += hEntity.getCitationCount();
        }
        return value;
    }
}
