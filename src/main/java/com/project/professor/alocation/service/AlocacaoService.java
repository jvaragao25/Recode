package com.project.professor.alocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.alocation.entity.Alocacao;
import com.project.professor.alocation.repository.AlocacaoRepositorio;

@Service
public class AlocacaoService {
	
	private AlocacaoRepositorio alocacaoRepositorio;
	
	public AlocacaoService(AlocacaoRepositorio alocacaoRepositorio) {
		this.alocacaoRepositorio = alocacaoRepositorio;
	}
	
	// select all
	public List<Alocacao> findAll(){
		return alocacaoRepositorio.findAll();
	}
	//select by id
	public Alocacao findById(Long id) {
		return alocacaoRepositorio.findById(id).orElse(null);
	}
	//save (create)
	public Alocacao create(Alocacao alocacao) {
		alocacao.setId(null);
		return alocacaoRepositorio.save(alocacao);		
	}
	//save (update)
	public Alocacao update(Alocacao alocacao) {
		if(alocacaoRepositorio.existsById(alocacao.getId())) {
			return alocacaoRepositorio.save(alocacao);
		}
		else {
			return null;
		}
	}
	//delete by id
	public void deleteById(Long id) {
		if (alocacaoRepositorio.existsById(id)) {
			alocacaoRepositorio.deleteById(id);
		}
	}
	//delete all
	public void deleteAll() {
		alocacaoRepositorio.deleteAllInBatch();
	}


}
