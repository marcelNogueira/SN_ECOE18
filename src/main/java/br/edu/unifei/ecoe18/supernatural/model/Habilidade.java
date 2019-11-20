package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Habilidade implements Serializable{
	private static final long serialVersionUID = -8864383604628925315L;
	@Id
	private String nome;
	private String descricao;
	
}
