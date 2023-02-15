package com.yesdosoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yesdosoft.pojo.Student;

public class TestAutoincreament {
public static void main(String[]args)
{
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	
	SessionFactory factory=cfg.buildSessionFactory();
	
	Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();
	
	Student s=new Student();
	 s.setName("priyanka");
	
	Student s1=new Student();
			 s1.setName("Google");
	
	Student s2=new Student();
			 s2.setName("Opera");
	
	Student s3=new Student();
			 s3.setName("Mozzila");
	
	System.out.println("Object saved.."+session.save(s));
	System.out.println("Object saved.."+session.save(s1));
	System.out.println("Object saved.."+session.save(s2));
	System.out.println("Object saved.."+session.save(s3));
	
	tx.commit();
	factory.close();
    }

}
