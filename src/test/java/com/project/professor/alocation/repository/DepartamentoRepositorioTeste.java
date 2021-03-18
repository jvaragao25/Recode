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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartamentoRepositorioTeste {
	
	@Autowired
	private DepartamentoRepositorio departamentoRepositorio;
	
	@Test
	public void findAll() {
		//Act
		List<Departamento> departamentos = departamentoRepositorio.findAll();	
		// Print
		System.out.println(departamentos);
	}
	@Test
	public void findById() {
		//Arrange
		Long id = 1L;
		
		//Act
		Optional<Departamento> departamento = departamentoRepositorio.findById(id);
		//Departamento departamento = departamentoOptional.orElse(null);
		//Print
		System.out.println(departamento);
		
	}
	@Test
	public void save_create() {
		//Arrange
		Departamento d = new Departamento();
		d.setId(null);
		d.setName("Departamento de Engenharia");
		//Act
		Departamento departamento = departamentoRepositorio.save(d);
		//Print
		System.out.println(departamento);
	}
	@Test
	public void save_upload() {
		//Arrange
		Departamento d = new Departamento();
		d.setId(7L);
		d.setName("Departamento de Engenharia 2");
		//Act
		Departamento departamento = departamentoRepositorio.save(d);
		//Print
		System.out.println(departamento);
	}
	@Test
	public void delete() {
		//Arrange
		Long id = 7L;
		
		//Act
		departamentoRepositorio.deleteById(id);
	}
	@Test
	public void deleteAll() {
		//Act
		departamentoRepositorio.deleteAllInBatch();
	}

}
