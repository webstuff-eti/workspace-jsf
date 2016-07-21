package br.eti.webstuff.register.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.eti.webstuff.register.dao.CompetenceDAO;
import br.eti.webstuff.register.model.Competence;
import br.eti.webstuff.register.model.Professional;


@ManagedBean
@ViewScoped
public class CompetenceBean {
	
	private Competence competence = new Competence();
	private Integer competenceId;

	public Competence getCompetence() {
		return competence;
	}
	
	public Integer getCompetenceId() {
		return competenceId;
	}
	public void setCompetenceId(Integer competenceId) {
		this.competenceId = competenceId;
	}
	
	
	
	public void competenceById() {
		
		CompetenceDAO dao = new CompetenceDAO();
		this.competence = dao.searchEntityById(Competence.class, competenceId); 
	}
	
	
	
    public String salvar() {
		
		System.out.println("Gravando competência " + this.competence.getTecnologia());
		System.out.println("Gravando competência " + this.competence.getDataLancamento());
		
		CompetenceDAO dao = new CompetenceDAO();
		
		if(this.competence.getId() == null){
			dao.createEntity(this.competence);
			this.competence = new Competence(); // Limpa Camppo
		}else{
			dao.updateEntity(this.competence);
			this.competence = new Competence(); // Limpa Camppo
		}
		return "professional?faces-redirect=true";
	}
    
    
	public List<Competence> getSkills() {
		
		CompetenceDAO dao = new CompetenceDAO();
		List<Competence> listSkills = dao.listCompetencies();
		
		return listSkills;
	}
	

	public void deletar(Competence competence, Integer id) {
		
		CompetenceDAO dao = new CompetenceDAO();
		dao.deleteEntity(Competence.class, id);
	}
	
	
	public void loadCompetence(Competence competence) {

		this.competence = competence;
	}

}
