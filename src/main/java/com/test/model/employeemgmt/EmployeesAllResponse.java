package com.test.model.employeemgmt;

import java.util.List;

import com.test.model.dbentity.Employee;

public class EmployeesAllResponse {
	
	List<Employee> employee;
	boolean success;
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
