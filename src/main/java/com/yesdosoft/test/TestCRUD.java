package com.yesdosoft.test;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yesdosoft.pojo.Employee;

public class TestCRUD {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		//add more object
		Employee e=new Employee();
		e.setId(101);
		e.setFirstname("Marks");
		e.setLastname("Zukerberg");
		e.setSalary(60000);
		
		//System.out.println("Object saved.."+Session.save(e));
		tx.commit();
		
		System.out.println("----------------------");
		//retrive all records
		Query q=session.createQuery("from Employee");
		List<Employee>list=q.list();
		for(Employee ee:list)
		{
			System.out.println(ee.getId()+" "+ee.getFirstname()+" "+ee.getLastname()+" "+ee.getSalary());
		}
		System.out.println("----------------------");
		//update query
		Session Session1=factory.openSession();
		Transaction tx1=Session1.beginTransaction();
		
		Employee emp=Session1.get(Employee.class,100);//return single instance of employee
		emp.setLastname("Dov");
		emp.setSalary(550000);
		
		Session1.update(emp);
		tx1.commit();
		System.out.println("emp obj having id 100 is updated");
		
		System.out.println("----------------------");
		//delete query
		Session Session2=factory.openSession();
		Transaction tx2=Session2.beginTransaction();
		Employee emp1=Session2.get(Employee.class,101);//return single instance of employee
		Session2.delete(emp1);
		tx2.commit();
		System.out.println("emp obj having id 101 is deleted");

	}

}
