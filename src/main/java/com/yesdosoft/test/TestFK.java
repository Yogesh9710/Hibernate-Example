package com.yesdosoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yesdosoft.pojo.Address;
import com.yesdosoft.pojo.Emp;

public class TestFK {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();

		Address a=new Address("pune","Maharashtra","India");
		
		Emp e=new Emp("ABC", a);
		
		System.out.println("Address object saved.."+session.save(a));
		int empid=(Integer) session.save(e);
		System.out.println("Emp object saved.."+session.save(e));
		
		tx.commit();
		
		Emp emp=session.get(Emp.class, empid);
		System.out.println("Emp id:"+emp.getId());
		System.out.println("Emp name:"+emp.getName());
		System.out.println("Emp Address:"+emp.getAddress());
	}

}
