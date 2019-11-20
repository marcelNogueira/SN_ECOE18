package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.FeiticoDAO;
import br.edu.unifei.ecoe18.supernatural.model.Feitico;
import lombok.Data;

@Data
@Named(value="feiticoBean")
@RequestScoped
public class FeiticoBean implements Serializable{
	private static final long serialVersionUID = -1992651504214528103L;
	private Feitico feitico = new Feitico(); 
	private FeiticoDAO fdao = new FeiticoDAO(); 
	public String inserir() {
		fdao.create(feitico);
		return "/index";
	}
	public String buscarConsultar() {
		feitico = fdao.find(feitico.getFeiticoId());
		if(feitico==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		feitico = fdao.find(feitico.getFeiticoId());
		if(feitico==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		feitico = fdao.find(feitico.getFeiticoId());
		if(feitico==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		fdao.update(feitico);
		return "/index";
	}
	public String excluir() {
		fdao.deleteKey(feitico.getFeiticoId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
