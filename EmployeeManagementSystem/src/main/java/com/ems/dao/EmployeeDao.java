package com.ems.dao;

import java.util.List;

import com.ems.Exception.EmployeeNotFoundException;
import com.ems.dto.Employee;

public interface EmployeeDao {
	/**
	 * Save Employees to database.
	 * @param employee input.
	 * @return
	 */

	 String saveEmployee(final Employee employee);
	 
	 /**
	  * Fetches Employees based on the employee else throws {@link EmployeeNotFoundException}.
	  * @param employeeId
	  * @return
	  */
	 
	 Employee getEmployee(final String employeeId) throws EmployeeNotFoundException;
	 
	 
	 /**
	  * Fetches all the Employess.
	  * @return
	  */
	 
	 List<Employee> findAllEmployess();
	 
	 /**
	  * Fetches Employees Between Min and Max Salary.
	  * @param minSalary
	  * @param maxSalary
	  * @return
	  */
	 
	 List<Employee> findEmployeesBetweenSalary(final Double minSalary,final Double maxSalary);
}
