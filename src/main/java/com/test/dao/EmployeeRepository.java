package com.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.test.model.dbentity.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	Employee findByEmpId(int empId);
	
}
