package com.example.demo.controller;

import com.example.demo.repository.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService service;   // MongoDb Service


    @Autowired
    public UserController(UserService service) {

        this.service = service;

    }

    /*
    Es:  http://localhost:8088/user/MRRSSxxxx
     */
     @GetMapping(path = "/user/{codFiscale}")
    public ResponseEntity<User> getUser(@PathVariable final String codFiscale) {
        Optional<User> user = service.getUser(codFiscale);

        return
                user.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    @GetMapping(path= "/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List <User> listUsers = service.getAllUsers();

        return ResponseEntity.ok(listUsers);
    }



    /*
    Es: http://localhost:8080/user/create
    {"codiceFiscale":"FLLRS...","name":"Federico","surname":"Levis" }
    per passare
User:
       @Id
    private String codiceFiscale;
    private String name;
    private String surname;


     */
    @PostMapping(path = "/user/create", consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody final User user) {

        return ResponseEntity.ok(service.storeUser(user));
    }

    @PostMapping(path = "/user/publish", consumes = "application/json")
    public ResponseEntity<Void> publishUser(@RequestBody final User user) {
        service.storeUser(user);
        return ResponseEntity.ok().build();
    }
}
