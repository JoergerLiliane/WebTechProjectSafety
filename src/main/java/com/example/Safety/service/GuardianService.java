package com.example.Safety.service;
import com.example.Safety.api.Guardian;
import com.example.Safety.api.GuardianCreateOrUpdateRequest;
import com.example.Safety.persistenceSQL.Gender;
import com.example.Safety.persistenceSQL.GuardianEntity;
import com.example.Safety.persistenceSQL.GuardianRepository;
import com.example.Safety.persistenceSQL.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


//Für Business Logik

@Service
public class GuardianService {


    private final GuardianRepository guardianRepository;
    private final UserRepository userRepository;


    public GuardianService(GuardianRepository guardianRepository, UserRepository userRepository) {
        this.guardianRepository = guardianRepository;
        this.userRepository = userRepository;
    }


    public List<Guardian> findAll() {
        List<GuardianEntity> guardians = guardianRepository.findAll();
        return guardians.stream()
                .map(this::entityIntoGuardian)
                .collect(Collectors.toList());
// (this::entityIntoGuardian)
    }

    //REST API lesen

    public Guardian findById(Long id) {
        var guardianEntity = guardianRepository.findById(id);
        //return guardianEntity.isPresent()? entityIntoGuardian(guardianEntity.get()) : null;

        return guardianEntity.map(this::entityIntoGuardian).orElse(null); //Bestehender Datensatz aus der Datenbank
    }


    //REST API anlegen

    public Guardian create(GuardianCreateOrUpdateRequest request) {
        var user  = userRepository.findById(request.getUserId()).orElseThrow();
        var gender = Gender.valueOf(request.getGender());
        var guardianEntity = new GuardianEntity(
                request.getFirstName(),
                request.getLastName(),
                gender,
                request.getPhoneNumber(),
                request.isGuardian(),
                request.getPriorityLevel(),
                user)

                ;


        guardianEntity = guardianRepository.save(guardianEntity);  //personEntity ohne ID
        //Service-Rückgabe der Person Entity an Client, welche eingegeben wird plus ID nach automatischer
        // ID Generierung von Springboot
        return entityIntoGuardian(guardianEntity);
    }


    //REST API aktualisieren

    public Guardian update(Long id, GuardianCreateOrUpdateRequest request) {
        var guardianOptionalEntity = guardianRepository.findById(id); //Bestehender Datensatz aus der Datenbank
        if (guardianOptionalEntity.isEmpty()) {
            return null;
        }

        var guardianEntity = guardianOptionalEntity.get(); //PersonEntity aus Optional rausnehmen

        //Aktualisieren der Daten, welches der Client geschickt hat
        guardianEntity.setFirstName(request.getFirstName());
        guardianEntity.setLastName(request.getLastName());
        guardianEntity.setGender(Gender.valueOf(request.getGender()));
        guardianEntity.setPhoneNumber(request.getPhoneNumber());
        guardianEntity.setGuardian(request.isGuardian());
        guardianEntity.setPriorityLevel(request.getPriorityLevel());

        guardianEntity = guardianRepository.save(guardianEntity); //personEntity mit ID

        return entityIntoGuardian(guardianEntity); //Aktualisierte personEntity
    }


    public boolean deleteById(Long id) {

        if (!guardianRepository.existsById(id)) { //Wenn die ID nicht existiert, dann gibt es nichts zu löschen
            return false;
        }
        guardianRepository.deleteById(id);
        return true;
    }

    //Mappen einer Entity in einer Person

    private Guardian entityIntoGuardian(GuardianEntity guardianEntity) {
        var gender = guardianEntity.getGender() != null ? guardianEntity.getGender().name() : Gender.UNKNOWN.name();
        return new Guardian(
                guardianEntity.getId(),
                guardianEntity.getFirstName(),
                guardianEntity.getLastName(),
                gender,
                guardianEntity.getPhoneNumber(),
                guardianEntity.isGuardian(),
                guardianEntity.getPriorityLevel(),
                guardianEntity.getUser().getId()


        );

    }
}












