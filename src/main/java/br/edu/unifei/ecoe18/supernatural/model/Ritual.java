package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Ritual implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2350206611857182093L;
	@Id
	@GeneratedValue
	private int ritualId;
	private String objetivo;
	private String descricao;
	@ManyToMany
	private List<Ingrediente> ingredientes = new ArrayList<>();

}
