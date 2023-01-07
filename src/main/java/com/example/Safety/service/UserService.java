package com.example.Safety.service;
import com.example.Safety.api.User;
import com.example.Safety.api.UserCreateOrUpdateRequest;
import com.example.Safety.persistenceSQL.Gender;
import com.example.Safety.persistenceSQL.UserEntity;
import com.example.Safety.persistenceSQL.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;


    public UserService(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }


    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(userTransformer::entityIntoUser)
                .collect(Collectors.toList());
// (this::entityIntoGuardian)
    }

    //REST API lesen

    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
       //return guardianEntity.isPresent()? entityIntoGuardian(guardianEntity.get()) : null;

        return userEntity.map(userTransformer::entityIntoUser).orElse(null); //Bestehender Datensatz aus der Datenbank
    }


    //REST API anlegen

    public User create(UserCreateOrUpdateRequest request) {
        var gender = Gender.valueOf(request.getGender());
        var userEntity = new UserEntity(
                request.getFirstName(),
                request.getLastName(),
                gender,
                request.getCountry(),
                request.getUserName(),
                request.getPassword()
                );
              /*  request.getPhoneNumber(),
                request.isUser());
        ;*/

        userEntity = userRepository.save(userEntity);  //personEntity ohne ID
        //Service-Rückgabe der Person Entity an Client, welche eingegeben wird plus ID nach automatischer
        // ID Generierung von Springboot
        return userTransformer.entityIntoUser(userEntity);
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

        return userTransformer.entityIntoUser(userEntity); //Aktualisierte personEntity
    }


    public boolean deleteById(Long id) {

        if (!userRepository.existsById(id)) { //Wenn die ID nicht existiert, dann gibt es nichts zu löschen
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }


}
