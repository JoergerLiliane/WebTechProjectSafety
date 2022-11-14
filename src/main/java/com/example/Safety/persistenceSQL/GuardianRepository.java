package com.example.Safety.persistenceSQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GuardianRepository extends JpaRepository <GuardianEntity, Long> {

    List<GuardianEntity> findAllByFirstName (String firstNameGuardian);
}
