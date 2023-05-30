package com.anywr.GestionSchool.services;

import java.util.List;

import com.anywr.GestionSchool.dto.StudentDTO;

public interface IEtudiantService {
    

    List<StudentDTO> getEtudiants(String classe, String enseignant, int page, int size);
    
  
}
