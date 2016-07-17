package br.eti.webstuff.register.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.eti.webstuff.register.dao.CompetenceDAO;
import br.eti.webstuff.register.dao.ProfessionalDAO;
import br.eti.webstuff.register.model.Competence;
import br.eti.webstuff.register.model.Professional;

@ManagedBean
@ViewScoped
public class ProfessionalBean {
	
	private      Integer competenceId; 
	private Professional professional = new Professional();
	
	public Integer getCompetenceId() {
		return competenceId;
	}
	public void setCompetenceId(Integer competenceId) {
		this.competenceId = competenceId;
	}
	
	public Professional getProfessional() {
		return professional;
	}
	
	
	
	private List<Professional> professionals;
	
	public List<Professional> getProfessionals() {
		
		ProfessionalDAO dao = new ProfessionalDAO();
		List<Professional>  professionals = null; //TODO: TESTAR, CASO D� ERRADO, RETIRAR
		if(this.professionals == null){
			this.professionals = dao.listSkills();
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
			// throw new RuntimeException
			//FacesContext.getCurrentInstance().addMessage("professional",
			//		new FacesMessage("Profissional, deve possui pelo menos uma compet�ncia!"));
			//return; 
			
			throw new RuntimeException("Profissional, deve possui pelo menos uma compet�ncia!");
		}
		
		
		ProfessionalDAO dao = null;
		
		//if(this.professional.getId() == null){
			dao = new ProfessionalDAO();
			dao.createEntity(this.professional);
		//}else{
		//	dao = new ProfessionalDAO();
		//	dao.updateEntity(this.professional);
		//}
	}
	
	
   public void removeProfessional(Professional Professional, Integer id) {
	   ProfessionalDAO dao = new ProfessionalDAO();
	   dao.deleteEntity(Competence.class, id);
   }
	
   
  
   
   public void saveCompetence() {
	   
	   CompetenceDAO dao = new CompetenceDAO();
	   
	   Competence competence =  dao.searchEntityById(Competence.class, this.competenceId); //this.competenceId
		
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
