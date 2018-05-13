package com.s2mbe.model.transfer;

public interface ScopusDocumentRow extends DashboardRow {

    int getScopusDocumentSumm();

    default int getValue() {
        return getScopusDocumentSumm();
    }
}
