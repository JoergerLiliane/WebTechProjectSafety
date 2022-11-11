package com.example.Safety.service;

import com.example.Safety.api.Person;
import com.example.Safety.api.PersonCreateRequest;
import com.example.Safety.persistenceSQL.PersonRepository;
import org.springframework.stereotype.Service;
import com.example.Safety.persistenceSQL.PersonEntity;
import java.util.List;
import java.util.stream.Collectors;


//Für Business Logik

@Service
public class PersonService {


    private final PersonRepository personRepository;

    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List <Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream().
                map(this::entityIntoPerson)
                .collect(Collectors.toList());

    }

    //REST API lesen

    public Person findById (Long id) {
        var personEntity = personRepository.findById(id);
        //return personEntity.isPresent()? entityIntoPerson(personEntity.get()) : null;
        return personEntity.map(this::entityIntoPerson).orElse(null);
    }

    //REST API anlegen
    public  Person create (PersonCreateRequest request) {
        var personEntity = new PersonEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getPhoneNumber(),
                request.isGuardian());
        personRepository.save(personEntity);
        //Service-Rückgabe der Person Entity an Client, welche eingegeben wird plus ID nach automatischer
        // ID Generierung von Springboot
        return entityIntoPerson(personEntity);
    }

    //Mappen einer Entity in einer Person

    private Person entityIntoPerson (PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getFirstName(),
                personEntity.getPhoneNumber(),
                personEntity.isGuardian());

    }
}




