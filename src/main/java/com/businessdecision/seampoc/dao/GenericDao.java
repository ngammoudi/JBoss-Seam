package com.businessdecision.seampoc.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.StaleObjectStateException;

public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	T get(PK id);

	/**
	 * Checks for existence of an object of type T using the id arg.
	 * 
	 * @param id
	 *            the id of the entity
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(PK id);

	/**
	 * Generic method to update an object.
	 * 
	 * @param object
	 *            the object to update
	 * @return the persisted object
	 */
	void update(T object)throws StaleObjectStateException;

	/**
	 * Generic method to merge an object.
	 * 
	 * @param object
	 *            the object to merge
	 * @return the persisted object
	 */
	T merge(T object);

	/**
	 * Generic method to save an object.
	 * 
	 * @param object
	 *            the object to save
	 * @return the persisted object
	 */
	void save(T object);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */
	void remove(PK id);

	/**
	 * Generic method to update collection of object.
	 * 
	 * @param object
	 *            the object to update
	 * @return the persisted object
	 */
	void updateCollection(List<T> object);

	/**
	 * Generic method to remove collection of object.
	 * 
	 * @param object
	 *            the object to remove
	 */
	void removeCollection(List<T> object);

}