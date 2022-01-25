package com.sbassement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sbassement.model.Employee;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, Integer>{

}
