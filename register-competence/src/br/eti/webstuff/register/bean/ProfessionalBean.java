package br.eti.webstuff.register.bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.eti.webstuff.register.dao.CompetenceDAO;
import br.eti.webstuff.register.dao.ProfessionalDAO;
import br.eti.webstuff.register.model.Competence;
import br.eti.webstuff.register.model.Professional;
import br.eti.webstuff.register.utils.InformationMsn;

@ManagedBean
@ViewScoped
public class ProfessionalBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
			this.professionals = dao.listAll(Professional.class);  
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
	
	public void salvar() throws IOException {
		
		if (professional.getCompetencies().isEmpty()) { 
			//throw new RuntimeException("Profissional, deve possui pelo menos uma competência!");
			//FacesContext.getCurrentInstance().addMessage("competence", new FacesMessage("Profissional, deve possui pelo menos uma competência!"));
			InformationMsn msn = new InformationMsn();
			msn.intenacionalizaRuntimeException("prop.msnpc");
			return; //Sem o return não é possível inibir que o profissional seja salva com pelo menos uma competencia
		}
		
		ProfessionalDAO dao = null;
		
		if(this.professional.getId() == null){
			dao = new ProfessionalDAO();
			dao.createEntity(this.professional);
			
			// Novo Profissional adicionado, listamos todos os Profissionais novamente
	        this.professionals = dao.listAll(Professional.class);  //listaTodos();	
	        this.professional = new Professional(); //Limpa campo após alterar profissional
		}else{
			dao = new ProfessionalDAO();
			dao.updateEntity(this.professional);
			 this.professional = new Professional(); //Limpa campo após alterar profissional 
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
		System.out.println("Chamando o formulário do Competence");
		return "competence?faces-redirect=true";
	}
	
	public String formProfessional() {
		System.out.println("Chamando o formulário do Competence");
		return "professional?faces-redirect=true";
	}

}
