package com.example.Safety.service;
import com.example.Safety.api.GuardianCreateOrUpdateRequest;
import com.example.Safety.api.User;
import com.example.Safety.api.UserCreateOrUpdateRequest;
import com.example.Safety.persistenceSQL.Gender;
import com.example.Safety.persistenceSQL.GuardianEntity;
import com.example.Safety.persistenceSQL.UserEntity;
import com.example.Safety.persistenceSQL.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }


    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(this::entityIntoUser)
                .collect(Collectors.toList());
// (this::entityIntoGuardian)
    }

    //REST API lesen

    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
        //return guardianEntity.isPresent()? entityIntoGuardian(guardianEntity.get()) : null;

        return userEntity.map(this::entityIntoUser).orElse(null); //Bestehender Datensatz aus der Datenbank
    }


    //REST API anlegen

    public User create(UserCreateOrUpdateRequest request) {
        var gender = Gender.valueOf(request.getGender());
        var userEntity = new UserEntity(
                request.getFirstName(),
                request.getLastName(),
                gender);
              /*  request.getPhoneNumber(),
                request.isUser());
        ;*/

        userEntity = userRepository.save(userEntity);  //personEntity ohne ID
        //Service-Rückgabe der Person Entity an Client, welche eingegeben wird plus ID nach automatischer
        // ID Generierung von Springboot
        return entityIntoUser(userEntity);
    }


    //REST API aktualisieren

    public User update(Long id, UserCreateOrUpdateRequest request) {
        var userOptionalEntity = userRepository.findById(id); //Bestehender Datensatz aus der Datenbank
        if (userOptionalEntity.isEmpty()) {
            return null;
        }

        var userEntity = userOptionalEntity.get(); //PersonEntity aus Optional rausnehmen

        //Aktualisieren der Daten, welches der Client geschickt hat
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setGender(Gender.valueOf(request.getGender()));
       /* userEntity.setPhoneNumber(request.getPhoneNumber());
        userEntity.setUser(request.isUser());*/


        userEntity = userRepository.save(userEntity); //personEntity mit ID

        return entityIntoUser(userEntity); //Aktualisierte personEntity
    }


    public boolean deleteById(Long id) {

        if (!userRepository.existsById(id)) { //Wenn die ID nicht existiert, dann gibt es nichts zu löschen
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    //Mappen einer Entity in einer User

    private User entityIntoUser(UserEntity userEntity) {
        var guardianId = userEntity.getGuardian().stream().map(GuardianEntity::getId).collect(Collectors.toList());
        var gender = userEntity.getGender() != null ? userEntity.getGender().name() : Gender.UNKNOWN.name();
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                gender,
                userEntity.getPhoneNumber(),
                userEntity.isUser(),
                guardianId

        );






    }
}
