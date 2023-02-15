package com.yesdosoft.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yesdosoft.pojo.Person;
import com.yesdosoft.pojo.PhoneNo;


public class TestOneToMany {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		PhoneNo p1=new PhoneNo();
		p1.setPhone_Id(101);
		p1.setPhone_No("7845125263");
		p1.setPhone_Type("personal");
		
		
		PhoneNo p2=new PhoneNo();
		p2.setPhone_Id(102);
		p2.setPhone_No("0523-784525");
		p2.setPhone_Type("Home");
		
		
		PhoneNo p3=new PhoneNo();
		p3.setPhone_Id(103);
		p3.setPhone_No("0523-1245365");
		p3.setPhone_Type("office");
		
		session.save(p1);session.save(p2);session.save(p3);
		
		Set<PhoneNo>phoneset=new HashSet<PhoneNo>();
		phoneset.add(p1); phoneset.add(p2); phoneset.add(p3);
		
		Person per=new Person();
		per.setPid(1);
		per.setPname("ABC");
		
		session.save(per);
		
		tx.commit();
		
		factory.close();
	}

}
