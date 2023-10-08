package com.test.model.employeemgmt;

import java.util.List;

import com.test.model.dbentity.Employee;

public class DeleteResponse {
	
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
	

}
