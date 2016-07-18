package br.eti.webstuff.register.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@NamedQuery(name = "Professional.consultAll", query= "SELECT p FROM Professional p")  

@Entity
public class Professional {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String setor;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Competence> competencies = new ArrayList<Competence>();
	
	
	public Professional() { //TODO: Atentar em colocar
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	
	public List<Competence> getCompetencies() {
		return competencies;
	}
	
	

	public void setCompetencies(List<Competence> competencies) {//Usado só no teste
		this.competencies = competencies;
	}

	public void addCompetenceList(Competence competence) {
		this.competencies.add(competence);
	}
	public void removeCompetence(Competence competence) {
		this.competencies.remove(competence); 
	}
	
}
