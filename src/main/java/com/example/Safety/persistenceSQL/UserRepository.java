package com.example.Safety.persistenceSQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

        List<UserEntity> findAllByFirstName (String firstNameUser);
}
