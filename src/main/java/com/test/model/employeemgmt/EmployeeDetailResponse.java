package com.test.model.employeemgmt;

import com.test.model.dbentity.Employee;

public class EmployeeDetailResponse {
	
	Employee employee;
	boolean success;
	String employeeErrorMsg;
	
	
	public String getEmployeeErrorMsg() {
		return employeeErrorMsg;
	}
	public void setEmployeeErrorMsg(String employeeErrorMsg) {
		this.employeeErrorMsg = employeeErrorMsg;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}
