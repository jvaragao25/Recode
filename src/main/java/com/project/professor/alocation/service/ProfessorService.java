package com.project.professor.alocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.alocation.entity.Professor;
import com.project.professor.alocation.repository.ProfessorRepositorio;

@Service
public class ProfessorService {
	
	private ProfessorRepositorio professorRepositorio;
	
	public ProfessorService (ProfessorRepositorio professorRepositorio) {
		this.professorRepositorio = professorRepositorio;
	}
	
	// select all
	public List<Professor> findAll(){
		return professorRepositorio.findAll();
	}
	//select by id
	public Professor findById(Long id) {
		return professorRepositorio.findById(id).orElse(null);
	}
	//save (create)
	public Professor create(Professor professor) {
		professor.setId(null);
		return professorRepositorio.save(professor);		
	}
	//save (update)
	public Professor update(Professor professor) {
		if(professorRepositorio.existsById(professor.getId())) {
			return professorRepositorio.save(professor);
		}
		else {
			return null;
		}
	}
	//delete by id
	public void deleteById(Long id) {
		if (professorRepositorio.existsById(id)) {
			professorRepositorio.deleteById(id);
		}
	}
	//delete all
	public void deleteAll() {
		professorRepositorio.deleteAllInBatch();
	}

}
