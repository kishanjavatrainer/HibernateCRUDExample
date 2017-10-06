package com.infotech.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createEmployee(session);
	    	//getEmployeebyId(session);
	    	//updateEmployeeById(session);
	    	//deleteEmployeeById(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }

	private static void deleteEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if(employee != null){
			session.beginTransaction();
			
			session.delete(employee);
			session.getTransaction().commit();
		}else{
			System.out.println("Employee doesn't exist with provideded Id..");
		}
	}

	private static void updateEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if(employee != null){
			employee.setSalary(40000.00);
			session.beginTransaction();
			
			session.update(employee);
			session.getTransaction().commit();
		}else{
			System.out.println("Employee doesn't exist with provideded Id..");
		}
		
	
	}

	private static void getEmployeebyId(Session session) {
		Employee employee = session.get(Employee.class, 20);
		if(employee != null){
			System.out.println(employee);
		}else{
			System.out.println("Employee doesn't exist with provideded Id..");
		}
		
	}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getEmployee());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
	}
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Martin Bingel");
		employee.setEmail("martin.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
