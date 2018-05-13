package com.s2mbe.model.transfer;

public interface ScopusCitationRow extends DashboardRow {
    int getScopusCitationSumm();

    default int getValue() {
        return getScopusCitationSumm();
    }
}
