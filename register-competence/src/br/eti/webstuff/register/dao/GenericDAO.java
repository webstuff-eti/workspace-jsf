package br.eti.webstuff.register.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;


public  abstract class GenericDAO implements IGenericsDao{
	

	@Override
	public <T> void createEntity(T entity) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public <T> T searchEntityById(Class<T> entityClass, Object id) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction();
		T entity = entityManager.find(entityClass, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public <T> void updateEntity(T entity) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public <T> void deleteEntity(Class<T> entityClass, Object id) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();	
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction();
		T entity = entityManager.find(entityClass, id);
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	

	@Override
	public <T> List<T> listAll(Class<T> entityClass) {

		EntityManager entityManager = new EntityManagerProducer().getEntityManager();	
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction();
		
		
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(entityClass);
		query.select(query.from(entityClass));

		List<T> list = entityManager.createQuery(query).getResultList();

		entityManager.close();
		return list;
		
	}

	
}
