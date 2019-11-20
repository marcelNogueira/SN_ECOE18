package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.NaturalDAO;
import br.edu.unifei.ecoe18.supernatural.model.Natural;
import lombok.Data;

@Data
@Named(value="naturalBean")
@RequestScoped
public class NaturalBean implements Serializable {
	private static final long serialVersionUID = -6669985670282433773L;
	private Natural natural = new Natural(); 
	private NaturalDAO ndao = new NaturalDAO(); 
	public String inserir() {
		ndao.create(natural);
		return "/index";
	}
	public String buscarConsultar() {
		natural = ndao.find(natural.getNome());
		if(natural==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		natural = ndao.find(natural.getNome());
		if(natural==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		natural = ndao.find(natural.getNome());
		if(natural==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		ndao.update(natural);
		return "/index";
	}
	public String excluir() {
		ndao.deleteKey(natural.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
