package com.yesdosoft.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yesdosoft.pojo.Employee;


public class Testsave {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Employee e=new Employee();
		e.setId(100);
		e.setFirstname("John");
		e.setLastname("Daov");
		e.setSalary(50000);
		
		System.out.println("object saved.."+session.save(e));
		
		tx.commit();
		factory.close();
		

	}

}
