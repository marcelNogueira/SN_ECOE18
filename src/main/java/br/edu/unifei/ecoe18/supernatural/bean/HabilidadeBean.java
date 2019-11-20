package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.HabilidadeDAO;
import br.edu.unifei.ecoe18.supernatural.model.Habilidade;
import lombok.Data;

@Data
@Named(value="habilidadeBean")
@RequestScoped
public class HabilidadeBean implements Serializable {
	private static final long serialVersionUID = 6353283938285185792L;
	private Habilidade habilidade = new Habilidade(); 
	private HabilidadeDAO hdao = new HabilidadeDAO(); 
	public String inserir() {
		hdao.create(habilidade);
		return "/index";
	}
	public String buscarConsultar() {
		habilidade = hdao.find(habilidade.getNome());
		if(habilidade==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		habilidade = hdao.find(habilidade.getNome());
		if(habilidade==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		habilidade = hdao.find(habilidade.getNome());
		if(habilidade==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		hdao.update(habilidade);
		return "/index";
	}
	public String excluir() {
		hdao.deleteKey(habilidade.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
