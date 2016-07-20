package br.eti.webstuff.register.tests;

import static org.junit.Assert.assertEquals;







import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.eti.webstuff.register.dao.CompetenceDAO;
import br.eti.webstuff.register.dao.EntityManagerProducer;
import br.eti.webstuff.register.dao.ProfessionalDAO;
import br.eti.webstuff.register.model.Competence;
import br.eti.webstuff.register.model.Professional;
import br.eti.webstuff.register.tests.build.Utilities;



public class GenericDAOTest {
	
	/*
	@Test
	public void populaTabelaCompetence(){
		
		EntityManagerProducer  emp = new EntityManagerProducer();
		EntityManager entityManager = emp.getEntityManager();
		
		entityManager.getTransaction().begin();
		
	
		Competence spring = Utilities.generateCompetence("spring-framework-bom-4.0.0.RELEASE", "12/01/2016");
		Competence jsf = Utilities.generateCompetence("Java Server Faces 2.2", "13/02/2016");
		Competence primefaces = Utilities.generateCompetence("Primefaces-5.3", "14/03/2016");
		Competence hibernate = Utilities.generateCompetence("hibernate-release-5.2.1.Final", "15/04/2016");
		Competence json = Utilities.generateCompetence("jackson-core-2.0.0", "16/05/2016");
		Competence bootstrap = Utilities.generateCompetence("bootstrap-3.3.6-dist", "17/06/2016");
		
		entityManager.persist(spring);
		entityManager.persist(jsf);
		entityManager.persist(primefaces);
		entityManager.persist(hibernate);
		entityManager.persist(json);
		entityManager.persist(bootstrap);

		entityManager.getTransaction().commit();
		entityManager.close();
		
		assertEquals("spring-framework-bom-4.0.0.RELEASE", spring.getTecnologia());
		assertEquals("12/01/2016", Utilities.parseDataToString ( spring.getDataLancamento()) ); 
		assertEquals("Java Server Faces 2.2", jsf.getTecnologia());
		assertEquals("13/02/2016", Utilities.parseDataToString ( jsf.getDataLancamento()) ); 
		assertEquals("Primefaces-5.3", primefaces.getTecnologia());
		assertEquals("14/03/2016", Utilities.parseDataToString ( primefaces.getDataLancamento()) ); 
		assertEquals("hibernate-release-5.2.1.Final", hibernate.getTecnologia());
		assertEquals("15/04/2016", Utilities.parseDataToString ( hibernate.getDataLancamento()) ); 
		assertEquals("jackson-core-2.0.0", json.getTecnologia());
		assertEquals("16/05/2016", Utilities.parseDataToString ( json.getDataLancamento()) ); 
		assertEquals("bootstrap-3.3.6-dist", bootstrap.getTecnologia());
		assertEquals("17/06/2016", Utilities.parseDataToString ( bootstrap.getDataLancamento()) ); 	
	}
	
	
	@Test
	public void deveEncontrarPeloNomeTecnologia(){
		
		CompetenceDAO competenceDAO = new CompetenceDAO();
		
		Competence competence = Utilities.generateCompetence("mockito-core-1.8.5.jar", "17/01/2016");
		
		competenceDAO.createEntity(competence);
		
		assertEquals("mockito-core-1.8.5.jar", competence.getTecnologia());
		assertEquals("17/01/2016", Utilities.parseDataToString ( competence.getDataLancamento()) ); 
	}
   */	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void deveEncontrarPeloNomeProfissional(){
		
		ProfessionalDAO professionalDAO = new ProfessionalDAO();
		CompetenceDAO competenceDAO = new CompetenceDAO();
		
		List<Competence> competencies = null;
		
		competencies = (List<Competence>) competenceDAO.listCompetencies();
		
		Professional professional = Utilities.generateProfessional("Tiago Tibães", "Developer Java", competencies);
		
		professionalDAO.createEntity(professional);
		
		assertEquals("Tiago Tibães", professional.getNome());
		assertEquals("Developer Java",  professional.getSetor() ); 
	}
	
	
	
	

}
