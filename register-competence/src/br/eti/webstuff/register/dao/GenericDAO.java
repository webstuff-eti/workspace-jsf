package br.eti.webstuff.register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDAO<T> {

	private final Class<T> classe;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	public void create(T t) {

		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void remove(T t) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(t));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(T t) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<T> listAll() {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> list = entityManager.createQuery(query).getResultList();
		entityManager.close();
		return list;
	}

	public T searchById(Integer id) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		T t = entityManager.find(classe, id);
		entityManager.close();
		return t;
	}

	public List<T> listAllByPage(int firstResult, int maxResults) {
		
		EntityManager entityManager = new EntityManagerProducer().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> list = entityManager.createQuery(query)
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
		entityManager.close();
		return list;
	}

}