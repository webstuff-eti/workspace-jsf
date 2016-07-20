package br.eti.webstuff.register.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("mysql");
	
	public EntityManager getEntityManager() {

		return entityManagerFactory.createEntityManager();
	}
	
	public void close(EntityManager em) {
		em.close();
	}

}
