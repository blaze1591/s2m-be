package com.s2mbe.model.transfer;

public interface DashboardRow {
    String getId();

    String getPhoto();

    String getFirstNameUa();

    String getMiddleNameUa();

    String getLastNameUa();

    default String getName() {
        return getLastNameUa() + " " + getFirstNameUa() + " " + getMiddleNameUa();
    }
}
