package com.example.Safety.service;

import com.example.Safety.api.Guardian;
import com.example.Safety.api.GuardianCreateOrUpdateRequest;
import com.example.Safety.persistenceSQL.GuardianEntity;
import com.example.Safety.persistenceSQL.GuardianRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


//Für Business Logik

@Service
public class GuardianService {


    private final GuardianRepository guardianRepository;

    private GuardianService guardianEntity = null;

    public GuardianService(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }


    public List<Guardian> findAll() {
        List<GuardianEntity> persons = guardianRepository.findAll();
        return persons.stream().
                map(this::entityIntoGuardian)
                .collect(Collectors.toList());

    }

    //REST API anlegen
    public Guardian create(GuardianCreateOrUpdateRequest request) {
        var guardianEntity = new GuardianEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getPhoneNumber(),
                request.isGuardian());
        guardianEntity.save(guardianEntity);  //personEntity ohne ID
        //Service-Rückgabe der Person Entity an Client, welche eingegeben wird plus ID nach automatischer
        // ID Generierung von Springboot
        return entityIntoGuardian(guardianEntity);
    }

    //Mappen einer Entity in einer Person

    private Guardian entityIntoGuardian(GuardianEntity guardianEntity) {
        return new Guardian(
                guardianEntity.getFirstName(),
                guardianEntity.getLastName(),
                guardianEntity.getPhoneNumber(),
                guardianEntity.isGuardian(),
                guardianEntity.getPriorityLevel()

        );

    }

    //Guardian Priorität



}




