package com.example.Safety.api;
import com.example.Safety.service.GuardianService;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class GuardianRestController {

    //private  List <Person> persons;  //Instanzvariable
    private final GuardianService guardianService;

    public GuardianRestController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

   //Business Logik, Mapping in Klasse Service: Leseanfrage
    @GetMapping(path = "/api/v1/guardian")
    public ResponseEntity <List <Guardian>>fetchGuardians() {
        return ResponseEntity.ok(guardianService.findAll());
    }

    //REST API: Resource anlegen mit Hilfe von HTTP Body/HTTP Post
    //Client sendet Server Daten (Schreibanfrage)
    @PostMapping (path = "/api/v1/guardian")
    public ResponseEntity<Void> createGuardian( @Valid @RequestBody GuardianCreateOrUpdateRequest request) throws URISyntaxException {
       var guardian =  guardianService.create(request);

       URI uri = new URI("/api/v1/guardian/" + guardian.getId());
       return ResponseEntity.created(uri).build();  //Location der neuen Ressource
    }


    //REST API:  Ressource lesen = Client fragt Daten an
    @GetMapping (path = "/api/v1/guardian/{id}")
    public ResponseEntity <Guardian> fetchGuardiansById(@PathVariable Long id) {
        var guardian =  guardianService.findById(id);
        return guardian != null? ResponseEntity.ok(guardian) : ResponseEntity.notFound().build(); // Gibt es die ID Rückgabewert der ID & Wenn es die ID nicht git Rückgabe null
    }


    //REST API: Resource aktualisieren
    @PutMapping  (path = "/api/v1/guardian/{id}")
    public ResponseEntity<Guardian> updateGuardian(@PathVariable Long id, @RequestBody GuardianCreateOrUpdateRequest request) {
        var guardian =  guardianService.update(id, request);
        return guardian != null? ResponseEntity.ok(guardian) : ResponseEntity.notFound().build();
    }

    //REST API: Resource löschen
    @DeleteMapping (path = "/api/v1/guardian/{id}")
    public ResponseEntity<Guardian> deleteGuardian(@PathVariable Long id) {
        boolean successful = guardianService.deleteById (id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
