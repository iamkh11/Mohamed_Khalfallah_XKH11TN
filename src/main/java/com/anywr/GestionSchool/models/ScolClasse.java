package com.anywr.GestionSchool.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "classes")
@Data
@NoArgsConstructor @AllArgsConstructor
public class ScolClasse {

    @Id
    private String id;

    @Indexed(unique = true , direction = IndexDirection.DESCENDING)
    private String nom;

    @DBRef
    private Enseignant enseignant;

    public ScolClasse(String nom) {
        this.nom = nom;
        
    }
    
    
}
