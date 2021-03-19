package com.project.professor.alocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.alocation.entity.Departamento;
import com.project.professor.alocation.repository.DepartamentoRepositorio;

@Service
public class DepartamentoService {
	
	private DepartamentoRepositorio departamentoRepositorio;
	
	public DepartamentoService (DepartamentoRepositorio departamentoRepositorio) {
		this.departamentoRepositorio = departamentoRepositorio;
	}
	
	// select all
	public List<Departamento> findAll(){
		return departamentoRepositorio.findAll();
	}
	//select by id
	public Departamento findById(Long id) {
		return departamentoRepositorio.findById(id).orElse(null);
	}
	//save (create)
	public Departamento create(Departamento departamento) {
		departamento.setId(null);
		return departamentoRepositorio.save(departamento);		
	}
	//save (update)
	public Departamento update(Departamento departamento) {
		if(departamentoRepositorio.existsById(departamento.getId())) {
			return departamentoRepositorio.save(departamento);
		}
		else {
			return null;
		}
	}
	//delete by id
	public void deleteById(Long id) {
		if (departamentoRepositorio.existsById(id)) {
			departamentoRepositorio.deleteById(id);
		}
	}
	//delete all
	public void deleteAll() {
		departamentoRepositorio.deleteAllInBatch();
	}

}

