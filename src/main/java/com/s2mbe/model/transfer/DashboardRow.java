package com.s2mbe.model.transfer;

public interface DashboardRow {
    String getPhoto();

    String getFirstNameUa();

    String getMiddleNameUa();

    String getLastNameUa();

    int getScopusCitationSumm();

    default String getName() {
        return getLastNameUa() + " " + getFirstNameUa() + " " + getMiddleNameUa();
    }

    default int getValue() {
        return getScopusCitationSumm();
    }
}
