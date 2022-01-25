/**
 * 
 */
package com.sbassement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@NotNull(message = "Employee id is mandatory")
	@Id
	private Integer employeeId;
	
	@NotEmpty(message = "Employee name is mandatory")
	private String name;
	
	@NotNull(message = "Employee salary is mandatory")
	private Double salary;
	
	@NotEmpty(message = "Employee designation is mandatory")
	private String designation;

	public Employee(Integer employeeId, String name, Double salary, String designation) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	public Employee() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", designation="
				+ designation + "]";
	}

}
