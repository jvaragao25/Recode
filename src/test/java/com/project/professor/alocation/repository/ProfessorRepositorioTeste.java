package com.project.professor.alocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.entity.Departamento;
import com.project.professor.alocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorRepositorioTeste {
	
	@Autowired
	private ProfessorRepositorio professorRepositorio;
	
	@Test
	public void findAll() {
		//Act
		List<Professor> professores = professorRepositorio.findAll();	
		// Print
		System.out.println(professores);
	}
	@Test
	public void findById() {
		//Arrange
		Long id = 1L;
		
		//Act
		Optional<Professor> professor = professorRepositorio.findById(id);
	
		//Print
		System.out.println(professor);
	}
	@Test
	public void save_create() {
		//Arrange
		Professor p = new Professor();
		p.setId(null);
		p.setName("Professor 1");
		//Act
		Professor professor = professorRepositorio.save(p);
		//Print
		System.out.println(professor);
	}
	@Test
	public void save_upload() {
		//Arrange
		Professor p = new Professor();
		p.setId(7L);
		p.setName("Professor 2");
		//Act
		Professor professor = professorRepositorio.save(p);
		//Print
		System.out.println(professor);
	}
	@Test
	public void delete() {
		//Arrange
		Long id = 7L;
		
		//Act
		professorRepositorio.deleteById(id);
	}
	@Test
	public void deleteAll() {
		//Act
		professorRepositorio.deleteAllInBatch();
	}

}
	


