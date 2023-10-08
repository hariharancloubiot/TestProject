package com.test.model.employeemgmt;

public class FileUploadResponse {

	String employeeErrorMsg;
	String filePath;
	String fileNotFound;
	boolean success;
	
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getFileNotFound() {
		return fileNotFound;
	}
	public void setFileNotFound(String fileNotFound) {
		this.fileNotFound = fileNotFound;
	}
	public String getEmployeeErrorMsg() {
		return employeeErrorMsg;
	}
	public void setEmployeeErrorMsg(String employeeErrorMsg) {
		this.employeeErrorMsg = employeeErrorMsg;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
