package br.eti.webstuff.register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.eti.webstuff.register.model.Competence;

public class CompetenceDAO extends GenericDAO {

	public List<Competence> listCompetencies() {

		EntityManager entityManager = new EntityManagerProducer()
				.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.getTransaction();

		Query query = entityManager.createNamedQuery("Competence.consultAll");

		@SuppressWarnings("unchecked")
		List<Competence> skills = ((List<Competence>) query.getResultList());

		entityManager.getTransaction().commit();
		entityManager.close();

		return skills;
	}
}
