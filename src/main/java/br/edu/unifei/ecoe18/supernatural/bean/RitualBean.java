package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.RitualDAO;
import br.edu.unifei.ecoe18.supernatural.model.Ritual;
import lombok.Data;

@Data
@Named(value="ritualBean")
@RequestScoped
public class RitualBean implements Serializable {
	private static final long serialVersionUID = 4681611749339259934L;
	private Ritual ritual = new Ritual(); 
	private RitualDAO rdao = new RitualDAO(); 
	public String inserir() {
		rdao.create(ritual);
		return "/index";
	}
	public String buscarConsultar() {
		ritual = rdao.find(ritual.getRitualId());
		if(ritual==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		ritual = rdao.find(ritual.getRitualId());
		if(ritual==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		ritual = rdao.find(ritual.getRitualId());
		if(ritual==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		rdao.update(ritual);
		return "/index";
	}
	public String excluir() {
		rdao.deleteKey(ritual.getRitualId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
