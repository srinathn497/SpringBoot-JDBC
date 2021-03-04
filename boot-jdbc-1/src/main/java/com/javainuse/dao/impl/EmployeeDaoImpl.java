package com.javainuse.dao.impl;


import java.sql.PreparedStatement;
import java.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.EmployeeDao;
import com.javainuse.model.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
		
	}
		
	
	 
	@Override
	public List<Employee> getAllEmployees(){
		//System.out.println("inside getAllEmployees impl");
		//String sql = "SELECT * FROM emp where mgr IS NOT NULL and comm IS NOT NULL";
		String sql = "SELECT * FROM emp";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setEmpno((Number)row.get("empno")); 
			emp.setEname((String)row.get("EName"));
			emp.setJob((String)row.get("job")); 
			emp.setMgr((Number)row.get("mgr"));
			emp.setHiredate((Date)row.get("hiredate"));
			emp.setSal((Number)row.get("sal"));
			emp.setComm((Number)row.get("comm"));
			emp.setDeptno((Number)row.get("deptno"));
			//System.out.println("inside getAllEmployees impl");
			 
			result.add(emp);
		}
		
		return result;
	}

	
	/*
	 * @Override public Employee getEmployeeById(String empId) { String sql =
	 * "SELECT * FROM employee WHERE empId = ?"; return
	 * (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new
	 * RowMapper<Employee>(){
	 * 
	 * @Override public Employee mapRow(ResultSet rs, int rwNumber) throws
	 * SQLException { Employee emp = new Employee();
	 * emp.setEmpId(rs.getString("empId")); emp.setEname(rs.getString("empName"));
	 * return emp; } }); }
	 */
	 
}
