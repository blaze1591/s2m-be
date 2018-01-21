package com.s2mbe.service;

import com.s2mbe.model.science.ScienceUnit;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BibtexService {
    List<ScienceUnit> parseBibtexFile(MultipartFile multipartFile);
}
