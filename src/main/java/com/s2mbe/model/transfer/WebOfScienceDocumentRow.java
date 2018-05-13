package com.s2mbe.model.transfer;

public interface WebOfScienceDocumentRow extends DashboardRow {

    int getWebOfScienceDocumentSumm();

    default int getValue() {
        return getWebOfScienceDocumentSumm();
    }
}
