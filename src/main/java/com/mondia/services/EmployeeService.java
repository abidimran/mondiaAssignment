package com.mondia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mondia.DAO.EmployeeReposiotory;
import com.mondia.entities.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeService.
 */
@Service
public class EmployeeService {
	
	/** The employee reposiotory. */
	@Autowired
	private EmployeeReposiotory employeeReposiotory;
	
	
	/**
	 * Gets the user all.
	 *
	 * @return the user all
	 */
	public List<Employee> getUserAll() {
			List<Employee> result = employeeReposiotory.findAll();
			return result;
	}
	
	/**
	 * Save user.
	 *
	 * @param empname the empname
	 * @param city the city
	 * @param email the email
	 */
	public void SaveUser(String empname,String city,String email)
	{
			Employee employee = new Employee();
			employee.setEmpname(empname);
			employee.setCity(city);
			employee.setEmail(email);
			employeeReposiotory.save(employee);		
	}
	
	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	public Employee getUser(long id)
	{
		Employee employee=employeeReposiotory.findById(id);
		return employee;
		
				
	}
	
	/**
	 * Update user.
	 *
	 * @param empname the empname
	 * @param city the city
	 * @param email the email
	 * @param id the id
	 * @return the employee
	 */
	public Employee updateUser(String empname,String city,String email,long id)
	{
		Employee employee=employeeReposiotory.findById(id);
			if (employee != null) {
				employee.setEmpname(empname);
				employee.setCity(city);
				employee.setEmail(email);
				employeeReposiotory.save(employee);
			}
		return employee;
	}
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<Employee> deleteUser(long id)
	{
		employeeReposiotory.deleteById(id);
		List<Employee> result = employeeReposiotory.findAll();
		return result;
	}

}
