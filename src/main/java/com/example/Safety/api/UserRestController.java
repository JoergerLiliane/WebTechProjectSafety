package com.example.Safety.api;
import com.example.Safety.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //Business Logik, Mapping in Klasse Service: Leseanfrage
    @GetMapping(path = "/api/v1/user")
    public ResponseEntity<List<User>> fetchUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    //REST API: Resource anlegen mit Hilfe von HTTP Body/HTTP Post
    //Client sendet Server Daten (Schreibanfrage)
    @PostMapping(path = "/api/v1/user")
    public ResponseEntity<Void> createUsers(@RequestBody UserCreateOrUpdateRequest request) throws URISyntaxException {
        var user =  userService.create(request);

        URI uri = new URI("/api/v1/user/" + user.getId());
        return ResponseEntity.created(uri).build();  //Location der neuen Ressource
    }


    //REST API:  Ressource lesen = Client fragt Daten an
    @GetMapping (path = "/api/v1/user/{id}")
    public ResponseEntity <User> fetchUsersById(@PathVariable Long id) {
        var user =  userService.findById(id);
        return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build(); // Gibt es die ID Rückgabewert der ID & Wenn es die ID nicht git Rückgabe null
    }


    //REST API: Resource aktualisieren
    @PutMapping(path = "/api/v1/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserCreateOrUpdateRequest request) {
        var user =  userService.update(id, request);
        return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    //REST API: Resource löschen
    @DeleteMapping (path = "/api/v1/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id, @RequestBody UserCreateOrUpdateRequest request) {
        boolean successful = userService.deleteById (id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
