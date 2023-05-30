package com.anywr.GestionSchool;


import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anywr.GestionSchool.enums.ERole;
import com.anywr.GestionSchool.models.Enseignant;
import com.anywr.GestionSchool.models.Etudiant;
import com.anywr.GestionSchool.models.Role;
import com.anywr.GestionSchool.models.ScolClasse;
import com.anywr.GestionSchool.repositories.EnseignantRepository;
import com.anywr.GestionSchool.repositories.EtudiantRepository;
import com.anywr.GestionSchool.repositories.RoleRepository;
import com.anywr.GestionSchool.repositories.ScolClasseRepository;

@SpringBootApplication
public class GestionSchoolApplication implements CommandLineRunner{
	
	private final RoleRepository roleRepository;

	private final EtudiantRepository etudiantRepository;
	private final EnseignantRepository enseignantRepository;
	private final ScolClasseRepository classeRepository;

	private static final Logger logger = LoggerFactory.getLogger(GestionSchoolApplication.class);
	public GestionSchoolApplication(RoleRepository roleRepository,ScolClasseRepository classeRepository,EnseignantRepository enseignantRepository,
									EtudiantRepository etudiantRepository) 
	{
		this.roleRepository=roleRepository;
		this.classeRepository=classeRepository;
		this.enseignantRepository=enseignantRepository;
		this.etudiantRepository=etudiantRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionSchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("############### Spring Start ###############");
		
		logger.info("############### Role INIT ###############");
		Optional<Role> adminRoleOptional = roleRepository.findByName(ERole.ROLE_ADMIN);
		if (adminRoleOptional.isEmpty()) {
			Role newAdminRole = new Role();
			newAdminRole.setName(ERole.ROLE_ADMIN);
			roleRepository.save(newAdminRole);
			logger.info("Initialized ROLE_ADMIN");
		}
		else {
			Role adminRole = adminRoleOptional.get();
			logger.info("ROLE_ADMIN already exists: {}", adminRole);
		}
		
		Optional<Role> userRoleOptional = roleRepository.findByName(ERole.ROLE_USER);
		if (userRoleOptional.isEmpty()) {
			Role newUserRole = new Role();
			newUserRole.setName(ERole.ROLE_USER);
			roleRepository.save(newUserRole);
			logger.info("Initialized ROLE_USER");
		}
		else {
			Role userRole = userRoleOptional.get();
			logger.info("ROLE_USER already exists: {}", userRole);
		}



		// Enseignant enseignant1 = new Enseignant( "Alice", "Won");
		// Enseignant enseignant2 = new Enseignant( "John", "Diro");
		// enseignantRepository.saveAll(Arrays.asList(enseignant1, enseignant2));
	
		// // Create and save instances of ScolClasse
		// ScolClasse classe1 = new ScolClasse("Math");
		// classe1.setEnseignant(enseignant1);
		// ScolClasse classe2 = new ScolClasse("Science");
		// classe2.setEnseignant(enseignant2);
		// classeRepository.saveAll(Arrays.asList(classe1, classe2));
	
		// // Create and save instances of Etudiant
		// Etudiant etudiant1 = new Etudiant("Sonia", "Johnson", classe1);
		// Etudiant etudiant2 = new Etudiant("Bob", "Smith", classe1);
		// Etudiant etudiant3 = new Etudiant("Charlie", "Brown", classe2);
		// Etudiant etudiant4 = new Etudiant("Gareth", "Bale", classe1);
		// Etudiant etudiant5 = new Etudiant("Declan", "Rice", classe1);
		// Etudiant etudiant6 = new Etudiant("Mason", "Mount", classe2);
		// Etudiant etudiant7 = new Etudiant("Jadon", "Sancho", classe2);
		// etudiantRepository.saveAll(Arrays.asList(etudiant1, etudiant2, etudiant3, etudiant4, etudiant5, etudiant6, etudiant7));

		
	}
	


}
