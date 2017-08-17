package com.businessdecision.seampoc.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.businessdecision.seampoc.dao.EmployeeDao;
import com.businessdecision.seampoc.model.Employee;

/**
 * 
 * @author administrateur
 * 
 */
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Integer>
		implements EmployeeDao {
	/**
	 * logger for this class
	 */
	private static final Log log = LogFactory.getLog(EmployeeDaoImpl.class);

	/**
	 * the constructor
	 */
	public EmployeeDaoImpl() {
		super(Employee.class);
	}

	/**
	 * the constructor
	 * 
	 * @param persistentClass
	 */
	public EmployeeDaoImpl(Class<Employee> persistentClass) {
		super(persistentClass);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		if (log.isInfoEnabled()) {
			log.info("getAllEmployees() -> START");
		}

		List<Employee> list = getHibernateTemplate().findByNamedQuery(
				"getAllEmployees");

		if (log.isInfoEnabled()) {
			log.info("getAllEmployees() -> END ");
		}
		return list;
	}

}
