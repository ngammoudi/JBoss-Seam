package com.businessdecision.seampoc.dao;

import java.util.List;

import com.businessdecision.seampoc.model.Employee;

public interface EmployeeDao extends GenericDao<Employee, Integer> {
	/**
	 * get all exists employees
	 * 
	 * @return
	 */
	List<Employee> getAllEmployees();

}
