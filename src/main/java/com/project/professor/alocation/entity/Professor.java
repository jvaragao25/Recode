package com.project.professor.alocation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data				
@Entity		


public class Professor {
	
	@Id				
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(unique=true, nullable=false)
	private String cpf;

	@ManyToOne
	@JoinColumn(name="dep_id", nullable=false)
	Departamento departamento;
	
	@OneToMany(mappedBy = "professor")
	private List<Alocacao> lista_alocacoes;
}
