package com.anywr.GestionSchool.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anywr.GestionSchool.dto.StudentDTO;
import com.anywr.GestionSchool.services.IEtudiantService;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantRestController {
    
    @Autowired
    private IEtudiantService etudiantService;


    // StudentDTO : Using Projection to JUST return the fields ID NOM PRENOM of STUDENT
    // String enseignant = Nom complet de l'enseignant

    // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/retrieve-etudiants-filtered")
    public ResponseEntity<?> getEtudiants(
            @RequestParam(value = "classe", required = false) String classe,
            @RequestParam(value = "enseignant", required = false) String enseignant,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) 
    {
        
        try {
            List<StudentDTO> etudiants = etudiantService.getEtudiants(classe, enseignant, page, size);
            if (etudiants.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(etudiants);
            } else {
                return ResponseEntity.ok(etudiants);
            }
        } catch (Exception e) {
            String errorMessage = "An error occurred while retrieving Students : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    
}
