package com.s2mbe.model.transfer;

public interface GoogleScholarCitationRow extends DashboardRow {
    int getGoogleScholarCitationSumm();

    default int getValue() {
        return getGoogleScholarCitationSumm();
    }
}
