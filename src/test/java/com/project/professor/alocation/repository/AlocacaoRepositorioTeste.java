package com.project.professor.alocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.entity.Alocacao;
import com.project.professor.alocation.entity.Departamento;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class AlocacaoRepositorioTeste {
	
	@Autowired
	private AlocacaoRepositorio alocacaoRepositorio;
	
	@Test
	public void findAll() {
		//Act
		List<Alocacao> alocacoes = alocacaoRepositorio.findAll();	
		// Print
		System.out.println(alocacoes);
	}
	@Test
	public void findById() {
		//Arrange
		Long id = 1L;
		
		//Act
		Optional<Alocacao> alocacao = alocacaoRepositorio.findById(id);

		//Print
		System.out.println(alocacao);
		
	}
	@Test
	public void save_create() {
		//Arrange
		Alocacao a = new Alocacao();
		a.setId(null);
		//Act
		Alocacao alocacao = alocacaoRepositorio.save(a);
		//Print
		System.out.println(alocacao);
	}
	@Test
	public void save_upload() {
		//Arrange
		Alocacao a = new Alocacao();
		a.setId(7L);
		//Act
		Alocacao alocacao = alocacaoRepositorio.save(a);
		//Print
		System.out.println(alocacao);
	}
	@Test
	public void delete() {
		//Arrange
		Long id = 7L;
		
		//Act
		alocacaoRepositorio.deleteById(id);
	}
	@Test
	public void deleteAll() {
		//Act
		alocacaoRepositorio.deleteAllInBatch();
	}

}


