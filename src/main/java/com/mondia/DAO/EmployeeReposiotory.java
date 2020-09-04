package com.mondia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mondia.entities.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeReposiotory.
 */
public interface EmployeeReposiotory extends JpaRepository<Employee, Long> {

	
	/**
	 * Find by id.
	 *
	 * @param i the i
	 * @return the employee
	 */
	public Employee findById(long i);
}
