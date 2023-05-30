package com.anywr.GestionSchool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anywr.GestionSchool.dto.StudentDTO;
import com.anywr.GestionSchool.models.Enseignant;
import com.anywr.GestionSchool.models.Etudiant;
import com.anywr.GestionSchool.models.ScolClasse;
import com.anywr.GestionSchool.repositories.EnseignantRepository;
import com.anywr.GestionSchool.repositories.EtudiantRepository;
import com.anywr.GestionSchool.repositories.ScolClasseRepository;
import com.anywr.GestionSchool.services.IEtudiantService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class GestionSchoolApplicationTests {

	@Autowired
	private EnseignantRepository enseignantRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private ScolClasseRepository classeRepository;

	@Autowired 
	private IEtudiantService etudiantService;

	@Test
	public void testCreateEtudiantAndClass() {
		
		ScolClasse classe = new ScolClasse("Science");
		classeRepository.save(classe);

		Etudiant student = new Etudiant("Sonia", "Mount",classe);
		etudiantRepository.save(student);
	}

	@Test
	public void testCreateTeacherAndClass() {


		Enseignant enseignant = new Enseignant( "Alice", "Won");
		enseignantRepository.save(enseignant);
		
		ScolClasse classe = classeRepository.findByNomIgnoreCase("Science");
		classe.setEnseignant(enseignant);
		classeRepository.save(classe);

	}


	@Test
	public void testFindClassByNom()
	{
		ScolClasse classe = classeRepository.findByNomIgnoreCase("Science");
	
		 log.info("classe : {}", classe);
	}

	@Test
	void testEtudiantsParams()
	{
		List<StudentDTO> students = etudiantService.getEtudiants("SCIENCE", "alice WON", 0, 3);
	
		 // Assert that the list of students is not empty
		//  assertNotNull(students);
		 

		for (StudentDTO s : students)
		{
		System.out.println(s);
		}

		 // Add an assertion to check the size of the returned list
		//  assertEquals(3, students.size());
	}
}
