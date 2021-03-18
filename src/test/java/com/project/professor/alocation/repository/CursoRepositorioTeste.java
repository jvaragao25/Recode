package com.project.professor.alocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.entity.Curso;
import com.project.professor.alocation.entity.Departamento;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CursoRepositorioTeste {
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@Test
	public void findAll() {
		//Act
		List<Curso> cursos = cursoRepositorio.findAll();	
		// Print
		System.out.println(cursos);
	}
	@Test
	public void findById() {
		//Arrange
		Long id = 1L;
		
		//Act
		Optional<Curso> curso = cursoRepositorio.findById(id);
		
		//Print
		System.out.println(curso);
		
	}
	@Test
	public void save_create() {
		//Arrange
		Curso c = new Curso();
		c.setId(null);
		c.setName("Engenharia de Computação");
		//Act
		Curso curso = cursoRepositorio.save(c);
		//Print
		System.out.println(curso);
	}
	@Test
	public void save_upload() {
		//Arrange
		Curso c = new Curso();
		c.setId(7L);
		c.setName("Engenharia de Produção");
		//Act
		Curso curso = cursoRepositorio.save(c);
		//Print
		System.out.println(curso);
	}
	@Test
	public void delete() {
		//Arrange
		Long id = 7L;
		
		//Act
		cursoRepositorio.deleteById(id);
	}
	@Test
	public void deleteAll() {
		//Act
		cursoRepositorio.deleteAllInBatch();
	}

}


