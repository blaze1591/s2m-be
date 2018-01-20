package com.s2mbe.service;

import org.springframework.web.multipart.MultipartFile;

public interface BibtexService {
    void parseBibtexFile(MultipartFile multipartFile);
}
