package com.mondia.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mondia.DAO.EmployeeReposiotory;
import com.mondia.entities.Employee;
import com.mondia.services.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 */
@SuppressWarnings("unchecked")

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	/** The employee reposiotory. */
	@SuppressWarnings("unused")
	@Autowired
	private EmployeeReposiotory employeeReposiotory;
	
	/** The employeeservice. */
	@Autowired
	private EmployeeService employeeservice;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public ResponseEntity<List<Employee>> getUsers() {
		try {
			List result = employeeservice.getUserAll();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	/**
	 * Save user.
	 *
	 * @param empname the empname
	 * @param city the city
	 * @param email the email
	 * @return the response entity
	 */
	@RequestMapping(value = "/saveuser", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<List<Employee>> SaveUser(@QueryParam("empname") String empname,
			@QueryParam("city") String city, @QueryParam("email") String email) {
		employeeservice.SaveUser(empname, city, email);
		try {
			List result = employeeservice.getUserAll();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	/**
	 * Update users list all.
	 *
	 * @param empname the empname
	 * @param city the city
	 * @param email the email
	 * @param empid the empid
	 * @return the response entity
	 */
	@RequestMapping(value = "/updateuser", method = { RequestMethod.PUT })
	public ResponseEntity<?> UpdateUsersListAll(@QueryParam("empname") String empname, @QueryParam("city") String city,
			@QueryParam("email") String email, @QueryParam("empid") Long empid) {
		try {
			Employee employee = employeeservice.updateUser(empname, city, email, empid);
			if (employee != null) {
				return new ResponseEntity<>("Record Updated Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Record Does not Exist", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Record Not Found", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@RequestMapping(value = "/fetchuser/{id}", method = { RequestMethod.GET })
	public ResponseEntity<?> getUser(@PathVariable Long id) {

		try {
			Employee employee = employeeservice.getUser(id);
			if (employee != null) {
				return ResponseEntity.status(HttpStatus.OK).body(employee);
			} else {
				return new ResponseEntity<>("Record Does not Exist", HttpStatus.NOT_FOUND);
			}

		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@RequestMapping(value = "/deleteuser/{id}", method = { RequestMethod.DELETE })
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		try {
			employeeservice.deleteUser(id);
			return new ResponseEntity<>("Record Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Record Not Found", HttpStatus.NOT_FOUND);
		}

	}

}
