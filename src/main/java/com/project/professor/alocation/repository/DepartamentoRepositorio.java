package com.project.professor.alocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.alocation.entity.Departamento;

@Repository

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long>{			//<entidade, tipo da chave primária da entidade>
	
	List<Departamento> findByNameContainingIgnoreCase(String name);
	
	
}
