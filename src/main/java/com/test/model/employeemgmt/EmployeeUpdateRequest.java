package com.test.model.employeemgmt;

import com.test.model.dbentity.Employee;

public class EmployeeUpdateRequest {
	Employee employee;
	 int employeeId;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
