package com.project.professor.alocation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
