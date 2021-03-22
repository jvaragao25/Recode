package com.project.professor.alocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.alocation.entity.Alocacao;
import com.project.professor.alocation.entity.Curso;
import com.project.professor.alocation.entity.Professor;

@Repository

public interface AlocacaoRepositorio extends JpaRepository<Alocacao, Long>{
	
	List<Alocacao> findByProfessor (Professor professor);
	List<Alocacao> findByCurso (Curso curso);

}
