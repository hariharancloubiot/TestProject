package com.test.model.employeemgmt;

import com.test.model.dbentity.Employee;

public class EmployeeUpdateResponse {
	Employee employee;
	boolean success;
	String employeeErrorMsg;
	

	public String getEmployeeErrorMsg() {
		return employeeErrorMsg;
	}

	public void setEmployeeErrorMsg(String employeeErrorMsg) {
		this.employeeErrorMsg = employeeErrorMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
