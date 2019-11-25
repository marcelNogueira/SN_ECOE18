package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.ArmaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.CriaturaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.EventoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.HabilidadeDAO;
import br.edu.unifei.ecoe18.supernatural.dao.LugarDAO;
import br.edu.unifei.ecoe18.supernatural.dao.RitualDAO;
import br.edu.unifei.ecoe18.supernatural.model.Arma;
import br.edu.unifei.ecoe18.supernatural.model.Criatura;
import br.edu.unifei.ecoe18.supernatural.model.Evento;
import br.edu.unifei.ecoe18.supernatural.model.Habilidade;
import br.edu.unifei.ecoe18.supernatural.model.Lugar;
import br.edu.unifei.ecoe18.supernatural.model.Ritual;
import br.edu.unifei.ecoe18.supernatural.model.StatusEnum;
import lombok.Data;

@Data
@Named(value="criaturaBean")
@RequestScoped
public class CriaturaBean implements Serializable {
	private static final long serialVersionUID = 4299025650381846415L;
	private Criatura criatura = new Criatura(); 
	private CriaturaDAO cdao = new CriaturaDAO();
	private List<Criatura> criaturas = cdao.findAll();
	private String key;
	
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
		
	public String inserir() {
		if(lugarId!=null) {
			criatura.setLugar(lugarDao.find(lugarId));		
		}
		try {
			cdao.create(criatura);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
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
		if(lugarId!=null) {
			criatura.setLugar(lugarDao.find(lugarId));		
		}
		try {
			cdao.update(criatura);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
		return "/index";
	}
	public String excluir() {
		cdao.deleteKey(key);
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
