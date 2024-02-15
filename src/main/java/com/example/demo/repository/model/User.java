package com.example.demo.repository.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//lombok: genero Get, Costruttoe senza Arg e Costruttore con Tutti gli Arg. C'e` anche Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
// @Document is an annotation provided by Spring data project: It is used to identify a domain object, which is persisted to MongoDB.
@Document(collection = "user_demo")
public class User {
    // Indica che si tratta di un Index
    @Id
    private String codiceFiscale;
    private String name;
    private String surname;
}
