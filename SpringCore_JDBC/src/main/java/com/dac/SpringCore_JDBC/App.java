package com.dac.SpringCore_JDBC;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) {

    	System.out.println( "Application started..!!!" );

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         
        EmployeeDAO jdbcEmployeeDAO = (EmployeeDAO) context.getBean("jdbcEmployeeDAO");
        Employee employee1 = new Employee(1, "Dipak", "Role");
        Employee emp2 = new Employee(2, "Dipak3", "Role");
        Employee emp3 = new Employee(3, "Dipak3", "Role");
        jdbcEmployeeDAO.save(employee1);
        jdbcEmployeeDAO.save(emp2);
        jdbcEmployeeDAO.save(emp3);
  
        System.out.println( "Saved..." );
        
        System.out.println( "----------- GET BY ID ----------------" );
        
        Employee employee2 = jdbcEmployeeDAO.getById(1);
        System.out.println(employee2);
        
        System.out.println( "---------- UPDATE BY ID -----------------" );
        
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Prakash");
        jdbcEmployeeDAO.update(emp);
        System.out.println("Updated..");
        
        System.out.println( "------------- DELETE BY ID  --------------" );
        
        jdbcEmployeeDAO.deleteById(2);
        System.out.println("Deleted..");
        
        System.out.println( "----------- GET ALL DATA BY DB ----------------" );
        
        List<Employee> list = jdbcEmployeeDAO.getAll();
        for (Employee employee : list) {
        	System.out.println(employee);
		}
        
        context.close();
        System.out.println( "Application Stoping..!!!" );
    }
}
