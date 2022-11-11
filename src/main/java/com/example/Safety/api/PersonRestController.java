package com.example.Safety.api;
import com.example.Safety.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PersonRestController {

    //private  List <Person> persons;  //Instanzvariable
    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

   //Business Logik, Mapping in Klasse Service: Leseanfrage
    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity <List <Person>>fetchPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    //REST API:  Ressource lesen = Client fragt Daten an
    @GetMapping (path = "/api/v1/persons/{id}")
    public ResponseEntity <Person> fetchPersonById (@PathVariable Long id) {
        var person =  personService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }


    //REST API: mit Hilfe von HTTP Body/HTTP Post: Client sendet Server Daten (Schreibanfrage)
    //Daten
    @PostMapping (path = "/api/v1/persons")
    public ResponseEntity<Void> creatPersons(@RequestBody PersonCreateRequest request) throws URISyntaxException {
       var person =  personService.create(request);

       URI uri = new URI("/api/v1/persons/" + person.getId());
       return ResponseEntity.created(uri).build();  //Location der neuen Ressource
    }

}
