package com.anywr.GestionSchool.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.domain.PageRequest;

import com.anywr.GestionSchool.dto.StudentDTO;
import com.anywr.GestionSchool.models.Enseignant;
import com.anywr.GestionSchool.models.Etudiant;
import com.anywr.GestionSchool.models.ScolClasse;
import com.anywr.GestionSchool.repositories.EnseignantRepository;
import com.anywr.GestionSchool.repositories.EtudiantRepository;
import com.anywr.GestionSchool.repositories.ScolClasseRepository;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EnseignantRepository enseignantRepository;
    private final ScolClasseRepository scolClasseRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository,EnseignantRepository enseignantRepository,ScolClasseRepository scolClasseRepository) {
        this.etudiantRepository = etudiantRepository;
        this.enseignantRepository = enseignantRepository;
        this.scolClasseRepository = scolClasseRepository;
    }

  
    
    public List<StudentDTO> getEtudiants(String classe, String enseignant, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        // case : class + teacher 
        if (classe != null && enseignant != null ){

            String[] names = splitHandler(enseignant);
            String prenom = names[0];
            String nom = names[1];
            Enseignant teacher = enseignantRepository.findByNomIgnoreCaseContainingOrPrenomIgnoreCaseContaining(nom,prenom);
            ScolClasse cls1 = scolClasseRepository.findByEnseignant(teacher);
          
            if ( cls1.getNom().equalsIgnoreCase(classe) ){
                return etudiantRepository.findByClasse(cls1, pageable);
            }else {
                return  new ArrayList<>();
            }
          
            
        } else if (classe != null) {
            // if class != null we dont need to find Students By Enseignant ( && enseignant != or == null)
            ScolClasse cls = scolClasseRepository.findByNomIgnoreCase(classe);
            return etudiantRepository.findByClasse(cls, pageable);

        } else if (enseignant != null ) {
            // Filtres : Nom de la classe et/ou "Nom complet (prenom + nom)" de l'enseignant
            String[] names = splitHandler(enseignant);
            String prenom = names[0];
            String nom = names[1];
            Enseignant teacher = enseignantRepository.findByNomIgnoreCaseContainingOrPrenomIgnoreCaseContaining(nom,prenom);
            ScolClasse cls = scolClasseRepository.findByEnseignant(teacher);
            return etudiantRepository.findByClasse(cls, pageable);
            
        } else {
            return etudiantRepository.findAllWithProjection(pageable);
        }
        
    }

    private String[] splitHandler(String fullName) {
        String[] names = fullName.split("\\s+");
        String prenom = "";
        String nom = "";
    
        if (names.length == 1) {
            prenom = names[0];
            nom = names[0];
        } else if (names.length == 2) {
            prenom = names[0];
            nom = names[1];
        }
    
        return new String[]{prenom, nom};
    }
    
}
