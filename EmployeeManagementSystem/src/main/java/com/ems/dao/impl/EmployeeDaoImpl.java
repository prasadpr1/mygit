package com.ems.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ems.Exception.EmployeeNotFoundException;
import com.ems.dao.EmployeeDao;
import com.ems.dto.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Map<String, Employee> employeeMap = new HashMap<>();
	
	private static final List<Employee> employess = new ArrayList<>();

	
	public EmployeeDaoImpl() {
		Employee employee = new Employee("323424", "Suresh", 25000.00D, "Software Engineer");
		employess.add(employee);
		employeeMap.put(employee.getEmployeeId(), employee);
	}
	
	@Override
	public String saveEmployee(Employee employee) {
		if (employee == null || employee.getEmployeeId() == null || employee.getEmployeeId().trim().length() == 0) {
			return "Employee or Employee id cannot be null or empty";
		}
		if(employeeMap.get(employee.getEmployeeId()) != null) {
			throw new RuntimeException("Employee already exist with given id "+employee.getEmployeeId());
		}
		employess.add(employee);
		employeeMap.put(employee.getEmployeeId(), employee);
		return "Employee Saved with id : " + employee.getEmployeeId();
	}

	@Override
	public Employee getEmployee(String employeeId) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return employeeMap.get(employeeId);
	}

	@Override
	public List<Employee> findAllEmployess() {
		// TODO Auto-generated method stub
		return employess;
	}

	@Override
	public List<Employee> findEmployeesBetweenSalary(Double minSalary, Double maxSalary) {
		return employess.stream().filter(e -> e.getSalary() > minSalary && e.getSalary() < maxSalary).toList();
	}

}
