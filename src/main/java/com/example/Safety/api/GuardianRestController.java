package com.example.Safety.api;
import com.example.Safety.service.GuardianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class GuardianRestController {

    //private  List <Person> persons;  //Instanzvariable
    private final GuardianService guardianService;

    public GuardianRestController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

   //Business Logik, Mapping in Klasse Service: Leseanfrage
    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity <List <Guardian>>fetchPersons() {
        return ResponseEntity.ok(guardianService.findAll());
    }

    //REST API: Resource anlegen mit Hilfe von HTTP Body/HTTP Post
    //Client sendet Server Daten (Schreibanfrage)
    @PostMapping (path = "/api/v1/persons")
    public ResponseEntity<Void> creatPersons(@RequestBody GuardianCreateOrUpdateRequest request) throws URISyntaxException {
       var person =  guardianService.create(request);

       URI uri = new URI("/api/v1/persons/" + person.getId());
       return ResponseEntity.created(uri).build();  //Location der neuen Ressource
    }

    /*
    //REST API:  Ressource lesen = Client fragt Daten an
    @GetMapping (path = "/api/v1/persons/{id}")
    public ResponseEntity <Guardian> fetchPersonById(@PathVariable Long id) {
        var person =  guardianService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build(); // Gibt es die ID Rückgabewert der ID & Wenn es die ID nicht git Rückgabe null
    }


    //REST API: Resource aktualisieren
    @PutMapping (path = "/api/v1/persons/{id}")
    public ResponseEntity<Guardian> updatePerson(@PathVariable Long id, @RequestBody GuardianCreateOrUpdateRequest request) {
        var person =  guardianService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    //REST API: Resource löschen
    @DeleteMapping (path = "/api/v1/persons/{id}")
    public ResponseEntity<Guardian> deletePerson(@PathVariable Long id, @RequestBody GuardianCreateOrUpdateRequest request) {
        boolean successful = guardianService.deleteById (id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }*/
}
