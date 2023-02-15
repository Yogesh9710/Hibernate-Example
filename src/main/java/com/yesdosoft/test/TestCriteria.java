package com.yesdosoft.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.yesdosoft.pojo.Emp1;

public class TestCriteria {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		//Create session factory object
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Create session obj
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Emp1 e=new Emp1();
		e.setId(500);
		e.setName("ADAMS");
		e.setSalary(15000);
		
		
		Emp1 e1=new Emp1();
		e1.setId(501);
		e1.setName("MARTIN");
		e1.setSalary(18000);
		
		Emp1 e2=new Emp1();
		e2.setId(502);
		e2.setName("ZARA");
		e2.setSalary(20000);
		
		Emp1 e3=new Emp1();
		e3.setId(503);
		e3.setName("FORD");
		e3.setSalary(25000);
		
		Emp1 e4=new Emp1();
		e4.setId(504);
		e4.setName("JOHN");
		e4.setSalary(10000);
		
		
		System.out.println("Emp oj saved:"+session.save(e));
		
		System.out.println("Emp oj saved:"+session.save(e1));
		
		System.out.println("Emp oj saved:"+session.save(e2));
		
		System.out.println("Emp oj saved:"+session.save(e3));
		
		System.out.println("Emp oj saved:"+session.save(e4));
		
		tx.commit();
		
		
		System.out.println("--------------Emp info using criteria queries-----------------");
		
		Criteria cr=session.createCriteria(Emp1. class);
		List<Emp1> emplist=cr.list();
		System.out.println("--------------All employee data-----------------");
		for(Emp1 ee:emplist)
		{
			
			System.out.println("Emp id: "+ee.getId());
			System.out.println("Emp name: "+ee.getName());
			System.out.println("Emp salary: "+ee.getSalary());
		}
		
		System.out.println("--------------Restrictions-----------------");
		//to get records having salary more than 25000
		Criteria cr1=session.createCriteria(Emp1. class);
		cr1.add(Restrictions.gt("salary", 25000));
		List<Emp1> emplist1=cr1.list();
		System.out.println("--------------Employee data having salary more than 25000-----------------");
		for(Emp1 ee:emplist1)
		{
			
			System.out.println("Emp id: "+ee.getId());
			System.out.println("Emp name: "+ee.getName());
			System.out.println("Emp salary: "+ee.getSalary());
		}
		
		System.out.println("--------------Restrictions less than 25000-----------------");
		//to get records having salary less than 25000
		Criteria cr2=session.createCriteria(Emp1. class);
		cr2.add(Restrictions.lt("salary", 25000));
		List<Emp1> emplist2=cr2.list();
		System.out.println("--------------Employee data having salary less than 25000-----------------");
		for(Emp1 ee:emplist2)
		{
			
			System.out.println("Emp id: "+ee.getId());
			System.out.println("Emp name: "+ee.getName());
			System.out.println("Emp salary: "+ee.getSalary());
		}
			
		System.out.println("--------------Restrictions (Emp name starts with ZARA)-----------------");
		Criteria cr3=session.createCriteria(Emp1. class);
		cr3.add(Restrictions.like("name", "ZARA%"));
		List<Emp1> emplist3=cr3.list();
		System.out.println("--------------Emp name starts with ZARA-----------------");
		for(Emp1 ee:emplist3)
		{
			
			System.out.println("Emp id: "+ee.getId());
			System.out.println("Emp name: "+ee.getName());
			System.out.println("Emp salary: "+ee.getSalary());
		}
			
		System.out.println("--------------Restrictions (between 10000 to 60000)-----------------");
		Criteria cr4=session.createCriteria(Emp1. class);
		cr4.add(Restrictions.between("salary", 10000,60000));
		List<Emp1> emplist4=cr4.list();
		System.out.println("--------------Emp data between 10000 to 60000-----------------");
		for(Emp1 ee:emplist4)
		{	
		
			System.out.println("Emp id: "+ee.getId());
			System.out.println("Emp name: "+ee.getName());
			System.out.println("Emp salary: "+ee.getSalary());
		}
		
		session.close();
		factory.close();

	}

}
