package com.s2mbe.model.transfer;

public interface WebOfScienceCitationRow extends DashboardRow {

    int getWebOfScienceCitationSumm();

    default int getValue() {
        return getWebOfScienceCitationSumm();
    }
}
