package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dao.EmployeeDao;
import com.ems.dto.Employee;

@RestController
@RequestMapping("/employess")
public class EmployeeManagementController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value="/{employee-id}",method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("employee-id") String employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllByRange(@RequestParam(name = "min-salary",required = false) Double minSalary,
			@RequestParam(name="max-salary",required = false) Double maxSalary) {
		if(minSalary == null || minSalary<0  || maxSalary == null || maxSalary<0)
			return employeeDao.findAllEmployess();
		return employeeDao.findEmployeesBetweenSalary(minSalary,maxSalary);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
}
