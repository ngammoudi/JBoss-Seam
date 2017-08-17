/**
 * 
 */
package com.businessdecision.seampoc.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.StaleObjectStateException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.businessdecision.seampoc.dao.GenericDao;

public class GenericDaoImpl<T, PK extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, PK> {
	/**
	 * Logger for this class
	 */

	private Class<T> persistentClass;

	/**
	 * Constructor that takes in a class to see which type of entity to persist
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
	public GenericDaoImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {

		List<T> returnList = super.getHibernateTemplate().loadAll(
				this.persistentClass);

		return returnList;

	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {

		T entity = (T) super.getHibernateTemplate().get(this.persistentClass,
				id);

		if (entity == null) {

			throw new ObjectRetrievalFailureException(this.persistentClass, id);
		}

		return entity;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(PK id) {

		T entity = (T) super.getHibernateTemplate().get(this.persistentClass,
				id);
		boolean returnboolean = entity != null;

		return returnboolean;
	}

	public void save(T object) {

		super.getHibernateTemplate().save(object);
		super.getHibernateTemplate().flush();

	}

	public void remove(PK id) {

		super.getHibernateTemplate().delete(this.get(id));
		super.getHibernateTemplate().flush();

	}

	@SuppressWarnings("unchecked")
	public T merge(T object) {

		T returnT = (T) super.getHibernateTemplate().merge(object);

		return returnT;

	}

	public void update(T object) throws StaleObjectStateException {
		super.getHibernateTemplate().update(object);
		super.getHibernateTemplate().flush();
	}

	public void updateCollection(List<T> object) {

		super.getHibernateTemplate().saveOrUpdateAll(object);
		super.getHibernateTemplate().flush();

	}

	public void removeCollection(List<T> obList) {

		getHibernateTemplate().deleteAll(obList);
		super.getHibernateTemplate().flush();

	}

}
