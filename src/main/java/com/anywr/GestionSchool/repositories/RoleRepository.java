package com.anywr.GestionSchool.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.anywr.GestionSchool.enums.ERole;
import com.anywr.GestionSchool.models.Role;


public interface RoleRepository extends MongoRepository<Role, String>{

	Optional<Role> findByName(ERole name);
    
}
