package com.project.professor.alocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.alocation.entity.Curso;
import com.project.professor.alocation.entity.Departamento;
import com.project.professor.alocation.repository.CursoRepositorio;

@Service
public class CursoService {
	
	private CursoRepositorio cursoRepositorio;
	
	public CursoService(CursoRepositorio cursoRepositorio) {
		this.cursoRepositorio = cursoRepositorio;
	}
	
	// select all
	public List<Curso> findAll(){
		return cursoRepositorio.findAll();
	}
	//select by id
	public Curso findById(Long id) {
		return cursoRepositorio.findById(id).orElse(null);
	}
	//save (create)
	public Curso create(Curso curso) {
		curso.setId(null);
		return cursoRepositorio.save(curso);		
	}
	//save (update)
	public Curso update(Curso curso) {
		if(cursoRepositorio.existsById(curso.getId())) {
			return cursoRepositorio.save(curso);
	}
		else {
			return null;
		}
	}
	//delete by id
	public void deleteById(Long id) {
		if (cursoRepositorio.existsById(id)) {
			cursoRepositorio.deleteById(id);
		}
	}
	//delete all
	public void deleteAll() {
		cursoRepositorio.deleteAllInBatch();
	}

}
