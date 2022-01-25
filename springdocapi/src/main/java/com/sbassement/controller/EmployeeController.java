package com.sbassement.controller;

/**
 * 
 */

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbassement.exception.MandatroyFieldsException;
import com.sbassement.model.Employee;
import com.sbassement.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

import static com.sbassement.constants.AppConstants.EMPLOYEE_BASE_PATH;;

@RestController
@RequestMapping(value = EMPLOYEE_BASE_PATH)
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Endpoint to save employee.
	 * 
	 * @param employee
	 * @return
	 */
	@Operation(summary = "Adds Employee")
	@PostMapping(value = "/add")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee, BindingResult errors) {
		if (errors.hasErrors()) {
			throw new MandatroyFieldsException("Input has missing fields:" + errors.getFieldErrors().stream()
					.map(e -> e.getDefaultMessage()).collect(Collectors.joining(",")));
		}
		Employee savedEmployee = this.employeeService.save(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
	}

	/**
	 * End point to fetch all the employees.
	 * 
	 * @return
	 */
	@Operation(summary = "Finds all Employees")
	@GetMapping(value = "/getAll", produces = { "application/json" })
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> empList = this.employeeService.findAll();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	/**
	 * Endpoint to update employee.
	 * 
	 * @param employee
	 * @param employeeId
	 * @return
	 */
	@Operation(summary = "Updates Employee")
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee,
			@PathVariable("id") Integer employeeId) {
		Employee updatedEmployee = this.employeeService.update(employee, employeeId);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	/**
	 * End point to delete memployee.
	 * 
	 * @param employeeId
	 * @return
	 */
	@Operation(summary = "Delete Employees By Employee Id")
	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer employeeId) {
		this.employeeService.delete(employeeId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	/**
	 * End point to fetch employee by id.
	 * 
	 * @param employeeId
	 * @return
	 */
	@Operation(summary = "Fetches Employee by Employee Id")
	@GetMapping(value = "get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer employeeId) {
		return new ResponseEntity<>(employeeService.findById(employeeId), HttpStatus.OK);
	}

}
