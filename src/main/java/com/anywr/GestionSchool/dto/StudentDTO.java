package com.anywr.GestionSchool.dto;

import org.springframework.beans.factory.annotation.Value;

public interface StudentDTO {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.nom}")
    String getNom();

    @Value("#{target.prenom}")
    String getPrenom();


    
}
