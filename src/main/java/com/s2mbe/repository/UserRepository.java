package com.s2mbe.repository;

import com.s2mbe.model.transfer.*;
import com.s2mbe.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByCredentialsUserName(String userName);

    User findByCredentialsUserNameOrEmail(String userName, String email);

    User findByEmail(String email);

    User findByRegistrationToken(String registrationToken);

    List<ScopusCitationRow> findTop10ByOrderByScopusCitationSummDesc();

    List<GoogleScholarCitationRow> findTop10ByOrderByGoogleScholarCitationSummDesc();

    List<WebOfScienceCitationRow> findTop10ByOrderByWebOfScienceCitationSummDesc();

    List<ScopusDocumentRow> findTop10ByOrderByScopusDocumentSummDesc();

    List<GoogleScholarDocumentRow> findTop10ByOrderByGoogleScholarDocumentSummDesc();

    List<WebOfScienceDocumentRow> findTop10ByOrderByWebOfScienceDocumentSummDesc();

    @Query(value = "{}")
    List<GoogleScholarIndexRow> findTop10GSUsersByIndex();

    @Query(value = "{}")
    List<ScopusIndexRow> findTop10ScopusUsersByIndex();

    @Query(value = "{}")
    List<WebOfScienceIndexRow> findTop10WOSUsersByIndex();

    @Query(value = "{}")
    List<HirshProjection> findListOfHirshProjections();

    @Query(value = "{cathedras.name: ?0}")
    List<User> findAllByCathedraName(String name);
}
