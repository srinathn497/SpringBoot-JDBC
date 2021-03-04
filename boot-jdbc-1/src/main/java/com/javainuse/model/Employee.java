package com.javainuse.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import oracle.sql.DATE;

@Component
public class Employee {

	private  Number empno;
	private String Ename;
	private String Job;
	private Number Mgr;
	@DateTimeFormat(pattern="yy-MMM-dd")
	private Date hiredate;
	private Number sal;
	private Number comm;
	private Number deptno;
	
	public Number getDeptno() {
		return deptno;
	}
	public void setDeptno(Number deptno) {
		this.deptno = deptno;
	}
	public Number getComm() {
		return comm;
	}
	public void setComm(Number comm) {
		this.comm = comm;
	}
	public Number getSal() {
		return sal;
	}
	public void setSal(Number sal) {
		this.sal = sal;
	}
	public Number getMgr() {
		return Mgr;
	}
	public void setMgr(Number mgr) {
		Mgr = mgr;
	}
	public Number getEmpno() {
		return empno;
	}
	public void setEmpno(Number empno) {
		this.empno = empno;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}

	
	
	 
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", Ename=" + Ename + ", Job=" + Job + ", Mgr=" + Mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	



	
}