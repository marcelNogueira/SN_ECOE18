package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.BruxaDAO;
import br.edu.unifei.ecoe18.supernatural.model.Bruxa;
import lombok.Data;

@Data
@Named(value="bruxaBean")
@RequestScoped
public class BruxaBean implements Serializable {
	private static final long serialVersionUID = 8256972432863881346L;
	private Bruxa bruxa = new Bruxa(); 
	private BruxaDAO bdao = new BruxaDAO(); 
	public String inserir() {
		bdao.create(bruxa);
		return "/index";
	}
	public String buscarConsultar() {
		bruxa = bdao.find(bruxa.getNome());
		if(bruxa==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		bruxa = bdao.find(bruxa.getNome());
		if(bruxa==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		bruxa = bdao.find(bruxa.getNome());
		if(bruxa==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		bdao.update(bruxa);
		return "/index";
	}
	public String excluir() {
		bdao.deleteKey(bruxa.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
