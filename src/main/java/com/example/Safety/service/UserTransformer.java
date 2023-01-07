package com.example.Safety.service;

import com.example.Safety.api.User;
import com.example.Safety.persistenceSQL.Gender;
import com.example.Safety.persistenceSQL.GuardianEntity;
import com.example.Safety.persistenceSQL.UserEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserTransformer {
    //Mappen einer Entity in einer User

    public User entityIntoUser(UserEntity userEntity) {
        var guardianId = userEntity.getGuardianId().stream().map(GuardianEntity::getId).collect(Collectors.toList());
        var gender = userEntity.getGender() != null ? userEntity.getGender().name() : Gender.UNKNOWN.name();
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                gender,
                userEntity.getPhoneNumber(),
                userEntity.isUser(),
                guardianId,
                userEntity.getCountry(),
                userEntity.getUserName(),
                userEntity.getPassword()

        );






    }
}
