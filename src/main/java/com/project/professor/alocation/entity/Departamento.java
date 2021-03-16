package com.project.professor.alocation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data				//Inclui todos os argumentos (Getters, Setters, Construtores)
@Entity				//Especifica que a classe é uma entidade
@Table (name = "departamento")		//Especifica a tabela principal representada pela classe/entidade (nome,...)

public class Departamento {
	
	@Id				//Especifica a chave primária de uma entidade
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Especifica a estratégia da geração de valores da chave primária
	private Long id;
	
	@Column(unique = true, nullable = false)		//Especifica o mapeamento atributo-coluna
	private String name;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "departamento")
	private List<Professor> lista_professores;
	


}
