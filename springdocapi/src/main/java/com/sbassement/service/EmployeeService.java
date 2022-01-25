/**
 * 
 */
package com.sbassement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbassement.dao.EmployeeRepository;
import com.sbassement.exception.EmployeeAlreadyExistsException;
import com.sbassement.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeService() {
	}

	/**
	 * Save Employees to InMemory.
	 * 
	 * @param employee
	 * @return
	 */
	@Transactional(value = TxType.REQUIRES_NEW)
	public Employee save(Employee employee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
		if(optionalEmployee.isPresent()) {
			throw new EmployeeAlreadyExistsException("Employee with id "+employee.getEmployeeId()+" already exists");
		}
		return employeeRepository.save(employee);
	}

	/**
	 * Lists all employess.
	 * 
	 * @return
	 */
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	/**
	 * Updates Employess.
	 * 
	 * @param updatedEmployee
	 * @param employeeId
	 * @return
	 */
	@Transactional(value = TxType.REQUIRES_NEW)
	public Employee update(Employee updatedEmployee, Integer employeeId) {
		updatedEmployee.setEmployeeId(employeeId);
		return employeeRepository.save(updatedEmployee);

	}

	/**
	 * Finds Employee with given id.
	 * 
	 * @param employeeId
	 * @return
	 */
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Employee findById(Integer employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	/**
	 * Drops an Employee.
	 * 
	 * @param employeeId
	 */
	@Transactional(value = TxType.REQUIRES_NEW)
	public void delete(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
