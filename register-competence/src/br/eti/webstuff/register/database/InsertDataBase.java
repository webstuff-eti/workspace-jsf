package br.eti.webstuff.register.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.eti.webstuff.register.dao.EntityManagerProducer;
import br.eti.webstuff.register.model.Competence;

public class InsertDataBase {

	public static void main(String[] args) {
		
		EntityManagerProducer  emp = new EntityManagerProducer();
		EntityManager entityManager = emp.getEntityManager();
		
		entityManager.getTransaction().begin();
		
	
		Competence spring = generateCompetence("spring-framework-bom-4.0.0.RELEASE", "12/01/2016");
		Competence jsf = generateCompetence("Java Server Faces 2.2", "13/02/2016");
		Competence primefaces = generateCompetence("Primefaces-5.3", "14/03/2016");
		Competence hibernate = generateCompetence("hibernate-release-5.2.1.Final", "15/04/2016");
		Competence json = generateCompetence("jackson-core-2.0.0", "16/05/2016");
		Competence bootstrap = generateCompetence("bootstrap-3.3.6-dist", "17/06/2016");
		
		entityManager.persist(spring);
		entityManager.persist(jsf);
		entityManager.persist(primefaces);
		entityManager.persist(hibernate);
		entityManager.persist(json);
		entityManager.persist(bootstrap);

		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	private static Competence generateCompetence(String tecnologia, String data) {
		Competence competence = new Competence();
		competence.setTecnologia(tecnologia);
		competence.setDataLancamento(parseData(data));
		return competence;
	}
	
	
	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}