package com.example.demo.service;

import com.example.demo.repository.model.User;
import com.example.demo.repository.model.UserRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> getUser(final String codFiscale) {
        log.info("Received get request for user {}",codFiscale);

        return repository.findById(codFiscale);
    }


    public List<User> getAllUsers() {
        log.info("getAllUsers");

        return repository.findAll();
    }


    public User storeUser(@NonNull User u) {

        return repository.save(u);
    }
}
