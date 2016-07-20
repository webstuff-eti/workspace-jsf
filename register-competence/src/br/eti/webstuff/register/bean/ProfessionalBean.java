package br.eti.webstuff.register.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.eti.webstuff.register.dao.CompetenceDAO;
import br.eti.webstuff.register.dao.ProfessionalDAO;
import br.eti.webstuff.register.model.Competence;
import br.eti.webstuff.register.model.Professional;

@ManagedBean
@ViewScoped
public class ProfessionalBean {
	
	private           Integer  competenceId; 
	private      Professional  professional = new Professional();
	private List<Professional> professionals;
	
	public Integer getCompetenceId() {
		return competenceId;
	}
	public void setCompetenceId(Integer competenceId) {
		this.competenceId = competenceId;
	}
	
	public Professional getProfessional() {
		return professional;
	}
	
	public List<Professional> getProfessionals() {
		ProfessionalDAO dao = new ProfessionalDAO();
		if(this.professionals == null){
			this.professionals = dao.listAll(Professional.class);  //listSkills();
		}
	    return professionals;
	}
	
	public void loadProfessional(Professional professional) {
		this.professional = professional;
	}

	public List<Competence> getCompetencies() { //selectItems
		CompetenceDAO competenceDAO = new CompetenceDAO();
		return  competenceDAO.listAll(Competence.class);
	}
	
	
	public List<Competence> getCompetenciesOfProfessional() {
		List<Competence> competecies = professional.getCompetencies();
		return competecies;
	}
	
	public void salvar() {
		
		System.out.println("Salvando profissional " + this.professional.getNome());
		System.out.println("Salvando profissional " + this.professional.getSetor());

		
		if (professional.getCompetencies().isEmpty()) { 
			throw new RuntimeException("Profissional, deve possui pelo menos uma compet�ncia!");
		}
		ProfessionalDAO dao = null;
		
		if(this.professional.getId() == null){
			dao = new ProfessionalDAO();
			dao.createEntity(this.professional);
			
			// Novo Profissional adicionado, listamos todos os Profissionais novamente
	        this.professionals = dao.listAll(Professional.class);  //listaTodos();
			
		}else{
			dao = new ProfessionalDAO();
			dao.updateEntity(this.professional);
		}
	}
	
   public void removeProfessional(Professional Professional, Integer id) {
	   ProfessionalDAO dao = new ProfessionalDAO();
	   dao.deleteEntity(Professional.class, id);
   }
	
   public void saveCompetence() {
	   
	   CompetenceDAO dao = new CompetenceDAO();
	   
	   Competence competence =  dao.searchEntityById(Competence.class, this.competenceId); 
		
	   this.professional.addCompetenceList(competence);
		
		System.out.println("ID Competence: " + competence.getId());
		System.out.println("Tecnologia   : " + competence.getTecnologia());
	}
	
	public void removeCompetenceOfProfessional(Competence competence) {
		this.professional.removeCompetence(competence);
	}
	
	public String formCompetence() {
		System.out.println("Chamando o formul�rio do Competence");
		return "competence?faces-redirect=true";
	}

}