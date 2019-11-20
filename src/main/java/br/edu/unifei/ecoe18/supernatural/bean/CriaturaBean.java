package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.CriaturaDAO;
import br.edu.unifei.ecoe18.supernatural.model.Criatura;
import lombok.Data;

@Data
@Named(value="criaturaBean")
@RequestScoped
public class CriaturaBean implements Serializable {
	private static final long serialVersionUID = 4299025650381846415L;
	private Criatura criatura = new Criatura(); 
	private CriaturaDAO cdao = new CriaturaDAO(); 
	public String inserir() {
		cdao.create(criatura);
		return "/index";
	}
	public String buscarConsultar() {
		criatura = cdao.find(criatura.getNome());
		if(criatura==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		criatura = cdao.find(criatura.getNome());
		if(criatura==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		criatura = cdao.find(criatura.getNome());
		if(criatura==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		cdao.update(criatura);
		return "/index";
	}
	public String excluir() {
		cdao.deleteKey(criatura.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
