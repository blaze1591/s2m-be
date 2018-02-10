package com.s2mbe.model.transfer;

public interface DashboardRow {
    String getPhoto();

    String getFirstNameUa();

    String getMiddleNameUa();

    String getLastNameUa();

    int getSumCitCount();

    default String getName() {
        return getLastNameUa() + " " + getFirstNameUa() + " " + getMiddleNameUa();
    }

    default int getValue() {
        return getSumCitCount();
    }
}
