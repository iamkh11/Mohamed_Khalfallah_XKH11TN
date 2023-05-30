package com.anywr.GestionSchool.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.anywr.GestionSchool.enums.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection  = "roles")
@Data @AllArgsConstructor @NoArgsConstructor
public class Role {
	 
    @Id
	private String id;

	private ERole name;

}
