package com.test.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.test.clib.util.JSONUtil;
import com.test.clib.util.SecureData;
import com.test.model.dbentity.Employee;
import com.test.model.employeemgmt.DeleteResponse;
import com.test.model.employeemgmt.EmployeeDeleteRequest;
import com.test.model.employeemgmt.EmployeeDetailResponse;
import com.test.model.employeemgmt.EmployeeSignupRequest;
import com.test.model.employeemgmt.EmployeeSignupResponse;
import com.test.model.employeemgmt.EmployeeUpdateRequest;
import com.test.model.employeemgmt.EmployeeUpdateResponse;
import com.test.model.employeemgmt.EmployeesAllResponse;
import com.test.model.employeemgmt.FileUploadResponse;
import com.test.service.EmployeeMgmtService;

@RestController
@RequestMapping("/api")
@CrossOrigin(maxAge = 3600)
public class EmployeeMgmtController {

	@Autowired
	private EmployeeMgmtService employeeMgmtService;

	private static final String UPLOAD_DIR = "C:/upload/";

	@PostMapping("/employees")
	public EmployeeSignupResponse registerUser(@RequestBody EmployeeSignupRequest request) {
		EmployeeSignupResponse response = new EmployeeSignupResponse();
		try {
			if (request.getEmployeeId() != 0) {
				Employee employeeRoleId = employeeMgmtService.getEmployeeRole(request.getEmployeeId());
				if (employeeRoleId.getRoleId() == 1) {
					Employee employee = new Employee();
					SecureData sd = new SecureData();
					String encryptedPassword = sd.encrypt(request.getEmployee().getPassword());
					employee.setFirstName(request.getEmployee().getFirstName());
					employee.setLastName(request.getEmployee().getLastName());
					employee.setEmail(request.getEmployee().getEmail());
					employee.setPassword(encryptedPassword);
					employee.setRoleId(2);
					employee.setPhoneNumber(request.getEmployee().getPhoneNumber());
					String loginToken = UUID.randomUUID().toString().replace("-", "");
					String shortToken = loginToken.substring(0, 10);
//					System.out.println("s2u2:"+shortToken);
					employee.setToken(shortToken);
					Employee retUser = employeeMgmtService.saveEmployee(employee);
					response.setEmployee(retUser);
					response.setSuccess(true);
				} else {
					response.setEmployeeErrorMsg("Not Authorized");
				}
			} else {
				response.setEmployeeErrorMsg("UserId Not valid");
			}
		} catch (NullPointerException npe) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("UserId is not valid");
		} catch (Exception e) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("Request Filed is not valid");
		}

		return response;
	}

	@GetMapping("/employees")
	public EmployeesAllResponse getList() {
		EmployeesAllResponse response = new EmployeesAllResponse();
		try {
			List<Employee> employeesList = employeeMgmtService.EmployeesList();
			response.setEmployee(employeesList);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
		}
		return response;
	}

	@GetMapping("/employees/{Id}")
	public EmployeeDetailResponse getUserById(@PathVariable int Id) {
		EmployeeDetailResponse response = new EmployeeDetailResponse();
		try {
			System.out.println("employee Tables");
			Employee employee = employeeMgmtService.getEmployee(Id);
			employee.setPassword(null);
			response.setEmployee(employee);
//			System.out.println(" Tables" + JSONUtil.toJson(employee ));
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("UserId is not valid");
		}
		return response;
	}

	@PutMapping("/employees/{Id}")
	public EmployeeUpdateResponse registerUser(@RequestBody EmployeeUpdateRequest request, @PathVariable int Id) {
		EmployeeUpdateResponse response = new EmployeeUpdateResponse();
		try {
			if (request.getEmployeeId() != 0) {
				Employee employeeRoleId = employeeMgmtService.getEmployeeRole(request.getEmployeeId());
				if (employeeRoleId.getRoleId() == 1) {
					Employee updateEmployee = employeeMgmtService.getEmployee(Id);
					updateEmployee.setFirstName(request.getEmployee().getFirstName());
					updateEmployee.setLastName(request.getEmployee().getLastName());
					updateEmployee.setEmail(request.getEmployee().getEmail());
					SecureData sd = new SecureData();
					String encryptedPassword = sd.encrypt(request.getEmployee().getPassword());
					updateEmployee.setPassword(encryptedPassword);
					updateEmployee.setPhoneNumber(request.getEmployee().getPhoneNumber());
					Employee retUser = employeeMgmtService.saveEmployee(updateEmployee);
					response.setEmployee(retUser);
					response.setSuccess(true);
				} else {
					response.setEmployeeErrorMsg("Not Authorized");
				}
			} else {
				response.setEmployeeErrorMsg("UserId Not valid");
			}
		} catch (NullPointerException npe) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("UserId is not valid");
		} catch (Exception e) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("Request Filed is not valid");
		}

		return response;
	}

	@DeleteMapping("/employees/{Id}")
	public DeleteResponse DeleteEmployee(@PathVariable int Id, @RequestBody EmployeeDeleteRequest request) {
		DeleteResponse response = new DeleteResponse();
		try {
			if (request.getEmployeeId() != 0) {
				Employee employeeRoleId = employeeMgmtService.getEmployeeRole(request.getEmployeeId());
				if (employeeRoleId.getRoleId() == 1) {

					System.out.println("Delete Employee");
					employeeMgmtService.deleteEmployee(Id);
//			System.out.println(" Tables" + JSONUtil.toJson(employee ));
					response.setSuccess(true);
				} else {
					response.setEmployeeErrorMsg("Not Authorized");
				}
			} else {
				response.setEmployeeErrorMsg("UserId Not valid");
			}
		} catch (NullPointerException npe) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("UserId is not valid");
		} catch (Exception e) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("Request Filed is not valid");
		}

		return response;
	}

	@PostMapping("/employees/{Id}/documents")
	public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable int Id) {
		FileUploadResponse response = new FileUploadResponse();

		try {
			if (Id != 0) {
				Employee employeeRoleId = employeeMgmtService.getEmployeeRole(Id);
				if (employeeRoleId.getRoleId() == 2) {
					if (file.isEmpty()) {
						response.setFileNotFound("Please select a file to upload.");
					}
					File uploadDir = new File(UPLOAD_DIR);
					if (!uploadDir.exists()) {
						uploadDir.mkdirs();
					}
					String fileName = file.getOriginalFilename();
					String filePath = UPLOAD_DIR + fileName;
					Employee addFilePath = employeeMgmtService.getEmployee(Id);
					addFilePath.setFilePath(filePath);

					file.transferTo(new File(filePath));
					response.setFilePath("File uploaded successfully: " + fileName);
				} else {
					response.setEmployeeErrorMsg("Not Authorized");
				}
			} else {
				response.setEmployeeErrorMsg("UserId Not valid");
			}
		} catch (NullPointerException npe) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("UserId is not valid");
		} catch (IOException e) {
			response.setEmployeeErrorMsg("File upload failed: " + e.getMessage());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setEmployeeErrorMsg("Request Filed is not valid");
		}
		return response;
	}

}
