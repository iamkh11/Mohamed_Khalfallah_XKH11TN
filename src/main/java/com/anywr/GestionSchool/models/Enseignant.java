package com.anywr.GestionSchool.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "teachers")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Enseignant {

    @Id
    private String id;

    private String prenom;
    private String nom;

    
    public Enseignant(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
    
}
