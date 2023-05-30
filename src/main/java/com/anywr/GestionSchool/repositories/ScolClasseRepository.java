package com.anywr.GestionSchool.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.anywr.GestionSchool.models.Enseignant;
import com.anywr.GestionSchool.models.ScolClasse;

public interface ScolClasseRepository extends MongoRepository<ScolClasse, String> {

    ScolClasse findByNomIgnoreCase(String nom);

    ScolClasse findByEnseignant(Enseignant teacher);
    

}
