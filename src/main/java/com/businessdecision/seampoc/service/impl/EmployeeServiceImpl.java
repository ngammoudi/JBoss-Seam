package com.businessdecision.seampoc.service.impl;

import java.util.List;

import org.hibernate.StaleObjectStateException;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Transactional;

import com.businessdecision.seampoc.dao.EmployeeDao;
import com.businessdecision.seampoc.model.Employee;
import com.businessdecision.seampoc.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@In
	EmployeeDao employeeDao;

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Transactional
	public void updateEmployee(Employee employee) throws StaleObjectStateException {
		employeeDao.update(employee);
	}

	public void deleteEmployee(Employee employee) {
		employeeDao.remove(employee.getId());

	}

	/**
	 * return employeeDao
	 * 
	 * @return
	 */
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	/**
	 * employeeDao to set
	 * 
	 * @param employeeDao
	 */

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}
