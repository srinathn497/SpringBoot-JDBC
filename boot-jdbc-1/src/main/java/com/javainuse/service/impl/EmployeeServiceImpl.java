package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.javainuse.dao.EmployeeDao;
import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	/*
	 * @Override public void insertEmployee(Employee employee) {
	 * employeeDao.insertEmployee(employee); }
	 * 
	 * @Override public void insertEmployees(List<Employee> employees) {
	 * employeeDao.insertEmployees(employees); }
	 */
	 

	public void getAllEmployees() 
	{
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
			//System.out.println("end");
		}
	}

	
	/*
	 * @Override public void getEmployeeById(String empId) {
	 * System.out.println("end"); Employee employee =
	 * employeeDao.getEmployeeById(empId); System.out.println(employee); }
	 */
	 

}
