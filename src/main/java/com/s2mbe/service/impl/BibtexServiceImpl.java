package com.s2mbe.service.impl;

import com.s2mbe.service.BibtexService;
import org.jbibtex.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Collection;
import java.util.Map;

@Service
public class BibtexServiceImpl implements BibtexService {
    private static BibTeXParser bibtexParser;

    public BibtexServiceImpl() throws ParseException {
        bibtexParser = new BibTeXParser();
    }

    @Override
    public void parseBibtexFile(MultipartFile multipartFile) {
        try {
            parseFile(multipartFile);
        } catch (IOException | ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void parseFile(MultipartFile multipartFile) throws IOException, ParseException {
        InputStream inputStream = multipartFile.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        BibTeXDatabase bibTeXDatabase = bibtexParser.parse(bufferedReader);
        Map<Key, BibTeXEntry> entryMap = bibTeXDatabase.getEntries();

        Collection<BibTeXEntry> entries = entryMap.values();
        for (BibTeXEntry entry : entries) {
            Value value = entry.getField(BibTeXEntry.KEY_TITLE);
            if (value == null) {
                continue;
            }
            System.out.println(value.toUserString());
        }
    }
}
