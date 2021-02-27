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
	  public void insertEmployee(Employee emp) { String sql =
	  "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)" ;
	  getJdbcTemplate().update(sql, new Object[]{ emp.getEmpId(), emp.getEmpName()
	  }); }
	  
	  @Override public void insertEmployees(List<Employee> employees) { String sql
	  = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
	  getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
	  public void setValues(PreparedStatement ps, int i) throws SQLException {
	  Employee employee = employees.get(i); ps.setString(1, employee.getEmpId());
	  ps.setString(2, employee.getEmpName()); }
	  
	  public int getBatchSize() { return employees.size(); } });
	  
	  }
	 
	@Override
	public List<Employee> getAllEmployees(){
		String sql = "SELECT * FROM emp";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setEmpno((String)row.get("empno"));
			emp.setEname((String)row.get("EName"));
			emp.setJob((String)row.get("job"));
			emp.setMgr((String)row.get("mgr"));
			emp.setHiredate((String)row.get("hiredate"));
			emp.setSal((String)row.get("sal"));
			emp.setComm((String)row.get("comm"));
			emp.setDeptno((String)row.get("deptno"));
			System.out.println("inside getAllEmployees impl");
			result.add(emp);
		}
		
		return result;
	}

	
	  @Override 
	  public Employee getEmployeeById(String empId) { String sql =
	  "SELECT * FROM employee WHERE empId = ?"; return
	  (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new
	  RowMapper<Employee>(){
	  
	  @Override public Employee mapRow(ResultSet rs, int rwNumber) throws
	  SQLException { Employee emp = new Employee();
	  emp.setEmpId(rs.getString("empId")); emp.setEname(rs.getString("empName"));
	  return emp; } }); }
	 
}
