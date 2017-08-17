package com.businessdecision.seampoc.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.StaleObjectStateException;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Synchronized;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;

import com.businessdecision.seampoc.model.Employee;
import com.businessdecision.seampoc.service.EmployeeService;
import com.businessdecision.seampoc.util.ConcurrentDataAccessException;

@Name("employeeAction")
@Scope(ScopeType.SESSION)
@Synchronized(timeout = 100000)
public class EmployeeAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Logger
	private Log log;
	@DataModel
	private List<Employee> employeeList;
	@DataModelSelection
	@In(required = false)
	@Out(required = false, value = "employee")
	private Employee employee;
	@In
	private EmployeeService employeeService;
	private Employee theEmployee;
	@In(create = true)
	private Renderer renderer;

	/**
	 * the subject of the sent email .
	 */
	private String subject;

	/**
	 * the body of the sent email .
	 */
	private String text;

	/**
	 * Method to get all existing employees
	 */
	@Factory("employeeList")
	public void readAllEmployees() {
		log.info("readAllEmployees -> START");
		employeeList = new ArrayList<Employee>();

		employeeList = employeeService.getAllEmployees();
		log.info("readAllEmployees -> END");
	}

	/**
	 * Method to save employee
	 * 
	 * @param employee
	 */
	public void saveEmployee(Employee employee) {
		log.info("saveEmployee ->START");
		try {
			employeeService.saveEmployee(employee);
		} catch (Exception e) {
			log.error("saveEmployee Failed : " + e.getMessage());

		}
		log.info("saveEmmployee ->END");
	}

	/**
	 * Method to update employee
	 * 
	 * @param employeeToUpdate
	 * @throws ConcurrentDataAccessException
	 */
	public void updateEmployee(Employee employee)
			throws StaleObjectStateException {
		log.info("updateEmployee ->START");
		try {
			employeeService.updateEmployee(employee);
		} catch (StaleObjectStateException e) {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), e.getMessage()));
			log.error("updateEmployee failed : " + e.getMessage());

		}
		log.info("updateEmployee ->END");
	}

	public void initEmployee() {
		employee = null;
		employee = new Employee();
	}

	public String editEmployee(Employee employeeToEdit) {
		log.info("editEmployee ->START");
		employee = employeeToEdit;
		log.info("editEmployee ->END");
		return "editEmployee";
	}

	/**
	 * Method to prepare employee to Delete
	 */
	public void prepareEmployeeToDelete(Employee employeeToDelete) {
		theEmployee = employeeToDelete;
		employee = new Employee();
		employee = employeeToDelete;
	}

	/**
	 * Method to delete employee
	 * 
	 * @param employee
	 */
	@Restrict("#{s:hasRole('SuperAdmin')}")
	public void deleteEmployee(Employee employee) {
		log.info("deleteEmployee ->START");
		try {
			employeeService.deleteEmployee(employee);
		} catch (Exception e) {
			log.error("deleteEmployee faile :" + e.getMessage());

		}
		log.info("deleteEmployee ->END");
	}

	/**
	 * to send the email to the chosen employee .
	 */
	public String send() {
		try {

			renderer.render("/emailToEmployee.xhtml");
			return "success";
		} catch (Exception ee) {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, ee
							.getMessage(), ee.getMessage()));
			return null;
		}

	}

	/**
	 * Method to fill the suggestionBox with emailAdrees of employees
	 * 
	 * @param suggest
	 * @return
	 */
	public List<Employee> getAllMailAddress(Object suggest) {

		String pref = (String) suggest;
		List<Employee> employeeListNames = new ArrayList<Employee>();

		employeeList = employeeService.getAllEmployees();

		for (Employee employee : employeeList) {
			if ((employee.getEmailAddress() != null && employee
					.getEmailAddress().toLowerCase()
					.indexOf(pref.toLowerCase()) == 0)
					|| "".equals(pref)) {
				employeeListNames.add(employee);
			}
		}
		return employeeListNames;

	}

	/**
	 * Method to initialize send mail
	 */
	public void sendMail() {

	}

	/**
	 * return employeeList
	 * 
	 * @return
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * employeeList to set
	 * 
	 * @param employeeList
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * return employee
	 * 
	 * @return
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * employee to set
	 * 
	 * @param employee
	 */
	public void setEmployee(Employee employee) {

		this.employee = employee;
	}

	/**
	 * return theEmployee
	 * 
	 * @return
	 */
	public Employee getTheEmployee() {
		return theEmployee;
	}

	/**
	 * theEmployee to set
	 * 
	 * @param theEmployee
	 */
	public void setTheEmployee(Employee theEmployee) {
		this.theEmployee = theEmployee;
	}

	/**
	 * return renderer
	 * 
	 * @return
	 */
	public Renderer getRenderer() {
		return renderer;
	}

	/**
	 * the renderer to set
	 * 
	 * @param renderer
	 */
	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}

	/**
	 * return subject
	 * 
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * the subject to set
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * return text
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * the text to set
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

}
