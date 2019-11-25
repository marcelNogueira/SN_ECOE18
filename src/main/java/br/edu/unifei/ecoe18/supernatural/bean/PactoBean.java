package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.EncruzilhadaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.NaturalDAO;
import br.edu.unifei.ecoe18.supernatural.dao.PactoDAO;
import br.edu.unifei.ecoe18.supernatural.model.Encruzilhada;
import br.edu.unifei.ecoe18.supernatural.model.Natural;
import br.edu.unifei.ecoe18.supernatural.model.Pacto;
import lombok.Data;

@Data
@Named(value="pactoBean")
@RequestScoped
public class PactoBean implements Serializable {
	private static final long serialVersionUID = -1987373363461582717L;
	private Pacto pacto = new Pacto(); 
	private PactoDAO pdao = new PactoDAO(); 
	private List<Pacto> pactos = pdao.findAll();
	private int pactoKey;
	
	private NaturalDAO naturalDao = new NaturalDAO();
	private List<Natural> naturais = naturalDao.findAll();
	private EncruzilhadaDAO edao = new EncruzilhadaDAO();
	private List<Encruzilhada> encruzilhadas = edao.findAll();
	private String encruzilhadaNome;
	private String naturalNome;
	
	public String inserir() {
		if(encruzilhadaNome!=null) {
			pacto.setDemonio(edao.find(encruzilhadaNome));		
		}
		if(naturalNome!=null) {
			pacto.setPessoa(naturalDao.find(naturalNome));		
		}
		try {
			pdao.create(pacto);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
		return "/index";
	}
	public String buscarConsultar() {
		pacto = pdao.find(pacto.getEnventoId());
		if(pacto==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		pacto = pdao.find(pacto.getEnventoId());
		if(pacto==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		pacto = pdao.find(pacto.getEnventoId());
		if(pacto==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		if(encruzilhadaNome!=null) {
			pacto.setDemonio(edao.find(encruzilhadaNome));		
		}
		if(naturalNome!=null) {
			pacto.setPessoa(naturalDao.find(naturalNome));		
		}
		try {
			pdao.update(pacto);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
		return "/index";
	}
	public String excluir() {
		pdao.deleteKey(pactoKey);
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
