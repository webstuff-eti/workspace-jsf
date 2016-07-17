package br.eti.webstuff.register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.eti.webstuff.register.model.Professional;

public class ProfessionalDAO extends GenericDAO {
	
	
	public List<Professional> listSkills() {

		EntityManager entityManager = new EntityManagerProducer()
				.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.getTransaction();

		Query query = entityManager.createNamedQuery("Professional.consultAll");

		@SuppressWarnings("unchecked")
		List<Professional> professionals = ((List<Professional>) query.getResultList());

		entityManager.getTransaction().commit();
		entityManager.close();

		return professionals;
	}

}
