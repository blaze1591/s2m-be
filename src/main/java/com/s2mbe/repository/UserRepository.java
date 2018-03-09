package com.s2mbe.repository;

import com.s2mbe.model.transfer.DashboardRow;
import com.s2mbe.model.transfer.HirshProjection;
import com.s2mbe.model.user.Cathedra;
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

    List<DashboardRow> findTop10ByOrderByScopusCitationSummDesc();

    @Query(value = "{}")
    List<HirshProjection> findListOfHirshProjections();

    @Query(value = "{cathedras.name: ?0}")
    List<User> findAllByCathedraName(String name);
}
