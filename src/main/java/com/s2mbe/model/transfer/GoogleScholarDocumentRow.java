package com.s2mbe.model.transfer;

public interface GoogleScholarDocumentRow extends DashboardRow {

    int getGoogleScholarDocumentSumm();

    default int getValue() {
        return getGoogleScholarDocumentSumm();
    }
}
