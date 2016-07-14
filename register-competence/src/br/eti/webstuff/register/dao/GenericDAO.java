package br.eti.webstuff.register.dao;


import javax.persistence.EntityManager;


public abstract class GenericDAO implements IGenericsDao{
	

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

	
}
