package com.anywr.GestionSchool.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "students")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Etudiant {

    @Id
    private String id;

    private String prenom;
    private String nom;

    @DBRef
    private ScolClasse classe;
    

    public Etudiant(String prenom, String nom, ScolClasse classe) {
        this.prenom = prenom;
        this.nom = nom;
        this.classe = classe;
    }
    
    
}
