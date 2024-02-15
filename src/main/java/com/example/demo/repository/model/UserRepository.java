package com.example.demo.repository.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Repository MOngo

 */

@Repository
public interface UserRepository extends MongoRepository<User,String> {



    List<User> findByNameAndSurname(final String name, final String surname);
}
