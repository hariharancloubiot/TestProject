package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.dbentity.Employee;


@Service
@Transactional
public class EmployeeQuery {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Employee>  ListOfEmployees() {
		String query="select * from employee";
		List<Employee> list = jdbcTemplate.query(query, new BeanPropertyRowMapper(Employee.class));
	  return list;
	}
	
	public void deleteEmployee(int empId) {
		String query="DELETE FROM employee WHERE emp_id="+ empId+"";
		 jdbcTemplate.execute(query);
	}
}
