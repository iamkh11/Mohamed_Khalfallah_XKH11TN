package com.anywr.GestionSchool.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.anywr.GestionSchool.models.Enseignant;

public interface EnseignantRepository extends MongoRepository<Enseignant, String> {

    Enseignant findByNomIgnoreCaseContainingOrPrenomIgnoreCaseContaining(String nom, String prenom);
    


}
