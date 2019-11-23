package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.ArmaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.EventoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.FantasmaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.HabilidadeDAO;
import br.edu.unifei.ecoe18.supernatural.dao.LugarDAO;
import br.edu.unifei.ecoe18.supernatural.dao.RitualDAO;
import br.edu.unifei.ecoe18.supernatural.model.Arma;
import br.edu.unifei.ecoe18.supernatural.model.Evento;
import br.edu.unifei.ecoe18.supernatural.model.Fantasma;
import br.edu.unifei.ecoe18.supernatural.model.Habilidade;
import br.edu.unifei.ecoe18.supernatural.model.Lugar;
import br.edu.unifei.ecoe18.supernatural.model.Ritual;
import br.edu.unifei.ecoe18.supernatural.model.StatusEnum;
import lombok.Data;

@Data
@Named(value="fantasmaBean")
@RequestScoped
public class FantasmaBean implements Serializable {
	private static final long serialVersionUID = 6267981810532856939L;
	private Fantasma fantasma = new Fantasma(); 
	private FantasmaDAO fdao = new FantasmaDAO(); 
	private List<Fantasma> fantasmas = fdao.findAll();
	
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
		fdao.create(fantasma);
		return "/index";
	}
	public String buscarConsultar() {
		fantasma = fdao.find(fantasma.getNome());
		if(fantasma==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		fantasma = fdao.find(fantasma.getNome());
		if(fantasma==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		fantasma = fdao.find(fantasma.getNome());
		if(fantasma==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		fdao.update(fantasma);
		return "/index";
	}
	public String excluir() {
		fdao.deleteKey(fantasma.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
