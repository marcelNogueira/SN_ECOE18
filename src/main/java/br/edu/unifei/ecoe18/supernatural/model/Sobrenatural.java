package br.edu.unifei.ecoe18.supernatural.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public abstract class Sobrenatural extends Ser {
	private static final long serialVersionUID = 8173591603658248705L;
	private String fraqueza;
	@ManyToMany
	private List<Habilidade> habilidades = new ArrayList<>();
	
//	public void matarVitima() {
//		chamarCacada();
//	}

}
