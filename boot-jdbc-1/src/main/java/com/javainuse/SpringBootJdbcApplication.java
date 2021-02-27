package com.javainuse;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javainuse.model.Employee;
 
@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM emp";
         
        List <Employee> Employees = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Employee.class));
         	//	System.out.println(Employees);
              Employees.forEach(System.out :: println);
    }
 
}