package com.anywr.GestionSchool.repositories;

import java.util.List;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.domain.Pageable;

import com.anywr.GestionSchool.dto.StudentDTO;
import com.anywr.GestionSchool.models.Etudiant;
import com.anywr.GestionSchool.models.ScolClasse;

public interface EtudiantRepository extends MongoRepository<Etudiant, String> {

    
    List<StudentDTO> findByClasse(ScolClasse cls, Pageable pageable);
    
    @Query(value = "{}", fields = "{ 'nom': 1, 'prenom': 1 }")

    List<StudentDTO> findAllWithProjection(Pageable pageable);
}

