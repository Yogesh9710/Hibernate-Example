package com.yesdosoft.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yesdosoft.pojo.Employee;

public class TestHQL {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		//Retrive record from table using hql
		Query q=session.createQuery("from Employee");
		List<Employee>emp=q.list();
		for(Employee e:emp)
		{
			System.out.println(e.getId()+" "+e.getFirstname()+" "+e.getLastname()+" "+e.getSalary());
		}

		
		//update query
		
		Query q1=session.createQuery("update Employee set firstname=:f,lastname=:l,salary=:s where id=:i");
		q1.setParameter("f","xyz");
		q1.setParameter("l","Dov");
		q1.setParameter("s","250000");
		q1.setParameter("i","100");
		q1.executeUpdate();
		tx.commit();
		System.out.println("record updated..");
		
		//query:
		//delete from Employee where id=:i
		
	}

}
