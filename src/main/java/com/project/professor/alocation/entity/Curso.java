package com.project.professor.alocation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data				
@Entity	

public class Curso {
	
	@Id				
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="curso")
	private List<Alocacao> lista_alocacao;

}
