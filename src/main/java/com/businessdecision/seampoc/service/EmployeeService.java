package com.businessdecision.seampoc.service;

import java.util.List;

import org.hibernate.StaleObjectStateException;

import com.businessdecision.seampoc.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	
	void updateEmployee(Employee employee) throws StaleObjectStateException;

	void deleteEmployee(Employee employee);
}
