package com.project.professor.alocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.alocation.entity.Professor;

@Repository

public interface ProfessorRepositorio extends JpaRepository<Professor, Long>{
	
	List<Professor> findByNameContainingIgnoreCase (String name);

}
