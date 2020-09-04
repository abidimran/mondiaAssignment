package com.mondia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
public class Employee {

	/** The empid. */
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Id
	private Long empid;
	
	/** The empname. */
	private String empname;
	
	/** The city. */
	private String city;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param empid the empid
	 * @param empname the empname
	 * @param city the city
	 * @param email the email
	 */
	public Employee(Long empid, String empname, String city, String email) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.city = city;
		this.email = email;
	}
	
	/**
	 * Gets the empid.
	 *
	 * @return the empid
	 */
	public Long getEmpid() {
		return empid;
	}
	
	/**
	 * Sets the empid.
	 *
	 * @param empid the new empid
	 */
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	
	/**
	 * Gets the empname.
	 *
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}
	
	/**
	 * Sets the empname.
	 *
	 * @param empname the new empname
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", city=" + city + ", email="
				+ email + "]";
	}
	
	
	
	
	
	
}
