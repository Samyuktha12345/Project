package com.namedqueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session ses=factory.openSession();
		Transaction tx=ses.beginTransaction();
		
		/*Student s=new Student();
		s.setSid(1);
		s.setSname("Hari");
		s.setScity("Hyderabad");
		
		Student s1=new Student();
		s1.setSid(2);
		s1.setSname("Manish");
		s1.setScity("Secunderabad");
		
		ses.save(s);
		ses.save(s1);*/
		
		Query query=ses.getNamedQuery("findstudentByName");
		 query.setInteger("ID1", 2);
		 List<Student>list=query.list();
		 for(int i=0;i<list.size();i++) {
			System.out.println("Name:"+list.get(i).getSname());
		 }
		 System.out.println(">>>>>"+list.size());
		 if(!list.isEmpty()) {
			Student e=(Student)list.get(0);
			 System.out.println(e);
		 }
		tx.commit();
		ses.close();
		factory.close();
		
	}
}
