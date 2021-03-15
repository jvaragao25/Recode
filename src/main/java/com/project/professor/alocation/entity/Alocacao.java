package com.project.professor.alocation.entity;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Alocacao {
	
	
	@Id				//Especifica a chave primária de uma entidade
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Especifica a estratégia da geração de valores da chave primária
	private Long id;
	
	@Enumerated(value=EnumType.STRING)	//Indica o tipo da coluna utilizado para mapear um atributo de tipo enumerado
	@Column(nullable=false)
	private DayOfWeek day;
	
	@Temporal(value=TemporalType.TIME)	//Indica o tipo da coluna mapeado ao tipo do atributo 
	@Column(nullable=false)
	private Date start;
	
	@Temporal(value=TemporalType.TIME)	//Indica o tipo da coluna mapeado ao tipo do atributo 
	@Column(nullable=false)
	private Date end;
	

}
