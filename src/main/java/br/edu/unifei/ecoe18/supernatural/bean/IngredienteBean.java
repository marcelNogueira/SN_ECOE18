package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.IngredienteDAO;
import br.edu.unifei.ecoe18.supernatural.model.Ingrediente;
import lombok.Data;

@Data
@Named(value="ingredienteBean")
@RequestScoped
public class IngredienteBean implements Serializable {
	private static final long serialVersionUID = -2673397149166165815L;
	private Ingrediente ingrediente = new Ingrediente(); 
	private IngredienteDAO idao = new IngredienteDAO(); 
	private List<Ingrediente> ingredientes = idao.findAll();
	private String ingredienteKey;
	public String inserir() {
		idao.create(ingrediente);
		return "/index";
	}
	public String buscarConsultar() {
		ingrediente = idao.find(ingrediente.getNome());
		if(ingrediente==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		ingrediente = idao.find(ingrediente.getNome());
		if(ingrediente==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		ingrediente = idao.find(ingrediente.getNome());
		if(ingrediente==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		idao.update(ingrediente);
		return "/index";
	}
	public String excluir() {
		idao.deleteKey(ingredienteKey);
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
