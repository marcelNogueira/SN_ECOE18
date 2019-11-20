package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.DemonioDAO;
import br.edu.unifei.ecoe18.supernatural.model.Demonio;
import lombok.Data;

@Data
@Named(value="demonioBean")
@RequestScoped
public class DemonioBean implements Serializable {
	private static final long serialVersionUID = 6027965607461957961L;
	private Demonio demonio = new Demonio(); 
	private DemonioDAO ddao = new DemonioDAO(); 
	public String inserir() {
		ddao.create(demonio);
		return "/index";
	}
	public String buscarConsultar() {
		demonio = ddao.find(demonio.getNome());
		if(demonio==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		demonio = ddao.find(demonio.getNome());
		if(demonio==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		demonio = ddao.find(demonio.getNome());
		if(demonio==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		ddao.update(demonio);
		return "/index";
	}
	public String excluir() {
		ddao.deleteKey(demonio.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
