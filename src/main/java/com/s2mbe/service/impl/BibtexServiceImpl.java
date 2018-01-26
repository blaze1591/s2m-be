package com.s2mbe.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.s2mbe.model.science.*;
import com.s2mbe.service.BibtexService;
import org.jbibtex.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BibtexServiceImpl implements BibtexService {
    private static BibTeXParser BIBTEX_PARSER;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    // TODO: Another types - class mapping
    private static final ImmutableMap<Key, Class<? extends ScienceUnit>> SCIENCE_UNIT_TYPES =
            ImmutableMap.<Key, Class<? extends ScienceUnit>> builder()
            .put(BibTeXEntry.TYPE_ARTICLE, Journal.class)
            .put(BibTeXEntry.TYPE_BOOK, Book.class)
            .put(BibTeXEntry.TYPE_INCOLLECTION, Chapter.class)
            .put(BibTeXEntry.TYPE_INPROCEEDINGS, Conference.class)
            .put(BibTeXEntry.TYPE_PHDTHESIS, Thesis.class)
            .build();

    public BibtexServiceImpl() throws ParseException {
        BIBTEX_PARSER = new BibTeXParser();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<ScienceUnit> parseBibtexFile(MultipartFile multipartFile) {
        try {
            return parseFile(multipartFile);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<ScienceUnit> parseFile(MultipartFile multipartFile) throws IOException, ParseException {
        InputStream inputStream = multipartFile.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        BibTeXDatabase bibTeXDatabase = BIBTEX_PARSER.parse(bufferedReader);
        Map<Key, BibTeXEntry> entryMap = bibTeXDatabase.getEntries();

        Collection<BibTeXEntry> entries = entryMap.values();

        List<ScienceUnit> scienceUnits = Lists.newArrayList();
        entries.forEach((entry) -> {
            ScienceUnit scienceUnit = createScienceUnit(entry);
            if (!isValid(scienceUnit)) {
                return;
            }
            scienceUnits.add(scienceUnit);
        });

        return scienceUnits;
    }

    private ScienceUnit createScienceUnit(BibTeXEntry entry) {
        Map<String, String> scienceUnitParams = Maps.newHashMap();
        Map<Key, Value> bibtexParams = entry.getFields();

        bibtexParams.forEach((bibtexKey, bibtexValue) -> {
            String key = bibtexKey.toString();
            String value = bibtexValue.toUserString().replace("{\\guillemotleft}","");
            if (key.equals("booktitle")) {
                key = "bookTitle";
            }
            if (key.equals("howpublished")) {
                key = "howPublished";
            }
            scienceUnitParams.put(key, value);
        });

        String name = scienceUnitParams.get("author") + " " + scienceUnitParams.get("year");
        Class<? extends ScienceUnit> scienceUnitType = SCIENCE_UNIT_TYPES.get(entry.getType());

        scienceUnitParams.put("name", name);
        scienceUnitParams.put("unitType", scienceUnitType.getSimpleName());

        return OBJECT_MAPPER.convertValue(scienceUnitParams, scienceUnitType);
    }

    private boolean isValid(ScienceUnit scienceUnit) {
        return !(Strings.isNullOrEmpty(scienceUnit.getAuthor()) ||
                Strings.isNullOrEmpty(scienceUnit.getTitle()) ||
                Strings.isNullOrEmpty(scienceUnit.getYear()));
    }
}
