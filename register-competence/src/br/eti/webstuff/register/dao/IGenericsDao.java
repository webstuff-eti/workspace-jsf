package br.eti.webstuff.register.dao;

import java.util.List;


public interface IGenericsDao {
	
	public abstract <T> void createEntity(T entity);

	public abstract <T> T searchEntityById(Class<T> entityClass, Object id);

	public abstract <T> void updateEntity(T entity);

	public abstract <T> void deleteEntity(Class<T> entityClass, Object id);
	
	public abstract <T> List<T> listAll(Class<T> entityClass);
	
}
