package com.s2mbe.model.transfer;

import com.s2mbe.model.hirsh.HirshEntity;
import com.s2mbe.model.hirsh.ScopusEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HirshProjection {
    static void sumDataHelper(List<? extends HirshEntity> hirshEntities, Map<Integer, Map<Integer, Map<String, Number>>> data) {
        for (HirshEntity he : hirshEntities) {
            LocalDate indexDate = he.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            if (data.containsKey(indexDate.getYear())) {
                Map<Integer, Map<String, Number>> yearData = data.get(indexDate.getYear());
                dealWithMonthesHelper(he, indexDate, yearData);
            } else {
                Map<Integer, Map<String, Number>> yearData = new HashMap<>();
                dealWithMonthesHelper(he, indexDate, yearData);
                data.put(indexDate.getYear(), yearData);
            }
        }
    }

    static void dealWithMonthesHelper(HirshEntity he, LocalDate indexDate, Map<Integer, Map<String, Number>> yearData) {
        if (yearData.containsKey(indexDate.getMonthValue())) {
            Map<String, Number> monthData = yearData.get(indexDate.getMonthValue());
            monthData.put("indexScopus", monthData.get("indexScopus").doubleValue() + he.getIndex());
            monthData.put("indexScholar", monthData.get("indexScholar").doubleValue() + he.getIndex());
            monthData.put("citationCount", monthData.get("citationCount").intValue() + he.getCitationCount());
            monthData.put("docCount", monthData.get("docCount").intValue() + he.getDocumentCount());
        } else {
            Map<String, Number> monthData = new HashMap<>();
            monthData.put("indexScopus", he.getIndex());
            monthData.put("indexScholar", he.getIndex());
            monthData.put("citationCount", he.getCitationCount());
            monthData.put("docCount", he.getDocumentCount());
            yearData.put(indexDate.getMonthValue(), monthData);
        }
    }

    List<ScopusEntity> getScopusEntities();

    String getFirstNameUa();

    String getMiddleNameUa();

    String getLastNameUa();

    String getScopus();

    String getAcademia();

    default String getName() {
        return getLastNameUa() + " " + getFirstNameUa() + " " + getMiddleNameUa();
    }
}
