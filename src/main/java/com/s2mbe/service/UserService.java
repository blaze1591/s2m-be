package com.s2mbe.service;

import com.s2mbe.model.transfer.*;
import com.s2mbe.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    User save(User user) throws Exception;

    void delete(String id);

    List<User> findAll();

    User findById(String id);

    User findByEmail(String email);

    User findByNameOrEmail(String userName, String email);

    List<ScopusCitationRow> findTop10ScopusUsersByCitation();

    List<WebOfScienceCitationRow> findTop10WOSUsersByCitation();

    List<GoogleScholarCitationRow> findTop10GSUsersByCitation();

    List<ScopusDocumentRow> findTop10ScopusUsersByDocument();

    List<WebOfScienceDocumentRow> findTop10WOSUsersByDocument();

    List<GoogleScholarDocumentRow> findTop10GSUsersByDocument();

    List<GoogleScholarIndexRow> findTop10GSUsersByIndex();

    List<ScopusIndexRow> findTop10ScopusUsersByIndex();

    List<WebOfScienceIndexRow> findTop10WOSUsersByIndex();

    Map<String, Object> findInfoForScopusReport();

    User findByName(String name);

    User activateUser(String registrationToken);

    boolean changePassword(String id, String newPassword);

    List<UserReportDTO> findDataForCathedraReport(String cathedraName);
}
