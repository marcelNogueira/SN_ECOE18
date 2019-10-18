package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Arma implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4302986000845612689L;
	@Id
	private String nome;
	private String descricao;
	private Boolean mitico;
	
}
