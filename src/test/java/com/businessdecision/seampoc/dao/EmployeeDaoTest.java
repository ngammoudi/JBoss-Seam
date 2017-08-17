//package com.businessdecision.seampoc.dao;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.apache.log4j.Logger;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.businessdecision.seampoc.dao.impl.EmployeeDaoImpl;
//import com.businessdecision.seampoc.model.Employee;
//import com.businessdecision.seampoc.service.impl.EmployeeServiceImpl;
//
//public class EmployeeDaoTest {
//	private static final Logger logger = Logger
//			.getLogger(EmployeeDaoTest.class);
//	private EntityManagerFactory emf;
//	private Employee employee;
//
//	@BeforeTest
//	public void init() {
//		if (logger.isDebugEnabled()) {
//			logger.debug("init() -> START");
//		}
//
//		emf = Persistence.createEntityManagerFactory("seamtest");
//		if (logger.isDebugEnabled()) {
//			logger.debug("init() -> END");
//		}
//	}
//
//	@Test
//	public void testSaveEmployee() {
//		if (logger.isDebugEnabled()) {
//			logger.debug("testSaveEmployee() -> START");
//		}
//		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
//		employeeDaoImpl.setEntityManager(emf.createEntityManager());
//		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
//		employeeService.setEmployeeDaoImpl(employeeDaoImpl);
//		employee = new Employee();
//		employee.setEmailAddress("gammoudi.neji@yahoo.fr");
//		employee.setFirstName("neji");
//		employee.setLastName("gammoudi");
//		employeeService.saveEmployee(employee);
//		assertEquals(employee.getFirstName(), "neji");
//		if (logger.isDebugEnabled()) {
//			logger.debug("testSaveEmployee() -> END");
//		}
//	}
//
//	@Test
//	public void testFindEmployee() {
//		testSaveEmployee();
//		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
//		employeeDaoImpl.setEntityManager(emf.createEntityManager());
//		List<Employee> employeeList = new ArrayList<Employee>();
//		employeeList = employeeDaoImpl.findEmployess(Employee.class);
//		assertNotNull(employeeList.size());
//	}
//
//	@Test
//	public void testUpdateEmployee() {
//		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
//		employeeDao.setEntityManager(emf.createEntityManager());
//		employee = new Employee();
//		employee.setEmailAddress("gammoudi.neji@yahoo.fr");
//		employee.setFirstName("neji");
//		employee.setLastName("gammoudi");
//		employeeDao.saveEmployee(employee);
//		employee.setEmailAddress("gammoudi.neji@gmail.com");
//		employeeDao.updateEmployee(employee);
//		assertEquals(employee.getEmailAddress(), "gammoudi.neji@gmail.com");
//	}
//
//	@AfterTest
//	public void close() {
//		if (logger.isDebugEnabled()) {
//			logger.debug("close() -> START");
//		}
//
//		emf.close();
//		if (logger.isDebugEnabled()) {
//			logger.debug("close() -> END");
//		}
//	}
//
//}
