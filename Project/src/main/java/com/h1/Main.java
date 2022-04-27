package com.h1;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
SessionFactory factory= new Configuration().configure().buildSessionFactory();
      	
    	Session ses= factory.openSession();
    	Transaction tx=ses.beginTransaction();
    	
    	Employee emp=new Employee();
    	emp.setId(1);
    	emp.setE_name("Samyuktha");
    	emp.setSalary(75000.00);
    	emp.setDesignation("Project Engineer");
    	emp.setCity("Hyderabad");
    	
    	Employee emp1=new Employee();
    	emp1.setId(2);
    	emp1.setE_name("Haripriya");
    	emp1.setSalary(65000.00);
    	emp1.setDesignation("Junior Engineer");
    	emp1.setCity("Secunderabad");
    	
    	Employee emp2=new Employee();
    	emp2.setId(3);
    	emp2.setE_name("Manish");
    	emp2.setSalary(55000.00);
    	emp2.setDesignation("Senior Engineer");
    	emp2.setCity("Monsorabad");
    	
    	Employee emp3=new Employee();
    	emp3.setId(4);
    	emp3.setE_name("Goutham");
    	emp3.setSalary(85000.00);
    	emp3.setDesignation("Project Leader");
    	emp3.setCity("Cyderabad");
    	
    	Employee emp4=new Employee();
    	emp4.setId(5);
    	emp4.setE_name("Chandhu");
    	emp4.setSalary(45000.00);
    	emp4.setDesignation("Team Leader");
    	emp4.setCity("Sainikpuri");
    	
    	ses.save(emp);
    	ses.save(emp1);
    	ses.save(emp2);
    	ses.save(emp3);
    	ses.save(emp4);
    	
    	Query query = ses.createQuery("from Employee");
    	List<Employee>List=query.list();
    	for(Employee e:List)
    	{
    		System.out.println("Emp Id:"+e.getId()+" ,Emp Name:"+e.getE_name()+" ,Emp Salary:"+e.getSalary()+" ,Emp Desig:"+e.getDesignation()+" ,Emp City:"+e.getCity()+"");
    		
    	}
    	Query query1=ses.createQuery("update Employee set e_name=:e_name where id=:id");
    	query1.setParameter("e_name", "Ram");
    	query1.setParameter("id", 5);
    	int result=query1.executeUpdate();
    	System.out.println("Update record:"+result);
    	
    	Query query2=ses.createQuery("delete Employee where id=:id");
    	
    	query2.setParameter("id", 5);
    	int result1=query2.executeUpdate();
    	System.out.println("Delete record:"+result1);
    	
    	query2=ses.createQuery("Select count(*) from Employee");
    	Iterator i=query2.iterate();
    	System.out.println("Number of rows:"+i.next());
    	
    	query2=ses.createQuery("Select max(salary) from Employee");
    	 i=query2.iterate();
    	System.out.println("Maximum salary:"+i.next());
    	
    	query2=ses.createQuery("from Employee where salary  between 45000 and 85000");
    	List<Employee>list1=query2.list();
    	for(Employee e1:list1)
    	{
    		System.out.println("Emp Name:"+e1.getE_name()+" ");
    	}
     query2 = ses.createQuery("from Employee order by e_name asc");
    	List<Employee>List2=query2.list();
    	for(Employee e2:List2)
    	{
    		System.out.println("Emp Id:"+e2.getId()+" ,Emp Name:"+e2.getE_name()+" ,Emp Salary:"+e2.getSalary()+" ,Emp Desig:"+e2.getDesignation()+" ,Emp City:"+e2.getCity()+"");
    		
    	}
    	
    	 query2 = ses.createQuery("from Employee where e_name like 'G%'");
     	List<Employee>List3=query2.list();
     	for(Employee e2:List3)
     	{
     		System.out.println("Emp Id:"+e2.getId()+" ,Emp Name:"+e2.getE_name()+" ,Emp Salary:"+e2.getSalary()+" ,Emp Desig:"+e2.getDesignation()+" ,Emp City:"+e2.getCity()+"");
     		
     	}
    	
     	query2=ses.createQuery("Select count(city) from Employee");
   	 i=query2.iterate();
   	System.out.println("Number of employees:"+i.next());
    	tx.commit();
    	ses.close();
    	factory.close();

	}

}
