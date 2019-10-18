package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Anjo extends Sobrenatural {
	private static final long serialVersionUID = 4864536980394403090L;
	private Boolean arcanjo;
	private Boolean graca;
	@Enumerated(EnumType.STRING)
	private NivelEnum nivel;
}
