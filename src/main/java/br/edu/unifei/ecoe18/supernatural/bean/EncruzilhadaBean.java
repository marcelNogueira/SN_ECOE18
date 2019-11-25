package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.ArmaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.EncruzilhadaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.EventoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.HabilidadeDAO;
import br.edu.unifei.ecoe18.supernatural.dao.LugarDAO;
import br.edu.unifei.ecoe18.supernatural.dao.RitualDAO;
import br.edu.unifei.ecoe18.supernatural.model.Arma;
import br.edu.unifei.ecoe18.supernatural.model.Encruzilhada;
import br.edu.unifei.ecoe18.supernatural.model.Evento;
import br.edu.unifei.ecoe18.supernatural.model.Habilidade;
import br.edu.unifei.ecoe18.supernatural.model.Lugar;
import br.edu.unifei.ecoe18.supernatural.model.NivelEnum;
import br.edu.unifei.ecoe18.supernatural.model.Ritual;
import br.edu.unifei.ecoe18.supernatural.model.StatusEnum;
import lombok.Data;

@Data
@Named(value="encruzilhadaBean")
@RequestScoped
public class EncruzilhadaBean implements Serializable {
	private static final long serialVersionUID = 291179116379819816L;
	private Encruzilhada encruzilhada = new Encruzilhada(); 
	private EncruzilhadaDAO edao = new EncruzilhadaDAO(); 
	private List<Encruzilhada> encruzilhadas = edao.findAll();
	private String encruzilhadaKey;
	
	//extends Ser
	private StatusEnum[] statusSer = StatusEnum.values();
	private EventoDAO eventoDao = new EventoDAO();
	private List<Evento> eventos = eventoDao.findAll();
	private LugarDAO lugarDao = new LugarDAO();
	private Integer lugarId;
	private List<Lugar> lugares = lugarDao.findAll();
	private RitualDAO ritualDao = new RitualDAO();
	private List<Ritual> rituais = ritualDao.findAll();
	private ArmaDAO armaDao = new ArmaDAO();
	private List<Arma> armas = armaDao.findAll();
	
	//extends Sobrenatural
	private HabilidadeDAO habilidadeDao = new HabilidadeDAO();
	private List<Habilidade> habilidades = habilidadeDao.findAll();
	
	private NivelEnum[] niveis = NivelEnum.values();
		
	public String inserir() {
		if(lugarId!=null) {
			encruzilhada.setLugar(lugarDao.find(lugarId));		
		}
		try {
			edao.create(encruzilhada);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
		return "/index";
	}
	public String buscarConsultar() {
		encruzilhada = edao.find(encruzilhada.getNome());
		if(encruzilhada==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		encruzilhada = edao.find(encruzilhada.getNome());
		if(encruzilhada==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		encruzilhada = edao.find(encruzilhada.getNome());
		if(encruzilhada==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		if(lugarId!=null) {
			encruzilhada.setLugar(lugarDao.find(lugarId));		
		}
		try {
			edao.update(encruzilhada);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
		return "/index";
	}
	public String excluir() {
		edao.deleteKey(encruzilhadaKey);
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
