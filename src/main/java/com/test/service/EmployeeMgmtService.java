package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.EmployeeQuery;
import com.test.dao.EmployeeRepository;
import com.test.model.dbentity.Employee;



@Service
@Transactional
public class EmployeeMgmtService {
	@Autowired
	private  EmployeeRepository employeeRepository;
	@Autowired
	private  EmployeeQuery employeeQuery;
	
	public Employee saveEmployee(Employee employee){
		return this.employeeRepository.save(employee);
	}
	public List<Employee> EmployeesList() {		
		return this.employeeQuery.ListOfEmployees();
	}
	public Employee getEmployee(int empId){
		return this.employeeRepository.findByEmpId(empId);
	}
	public Employee getEmployeeRole(int empId){
		return this.employeeRepository.findByEmpId(empId);
	}
	public void deleteEmployee(int empId){
		 this.employeeQuery.deleteEmployee(empId);
	}

}
