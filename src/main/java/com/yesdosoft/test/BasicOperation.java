package com.yesdosoft.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yesdosoft.pojo.Category;

public class BasicOperation {
	static SessionFactory factory;
	static {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		System.out.println("----------Configuration called-----in static block---------");
		
		//Create session factory object
		factory=cfg.buildSessionFactory();
		System.out.println("----------factoryobj return----------");
		
	}
	void saveCategory()
	{
		//save category records
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Category c=new Category(1,"Mens");
		
		Category c1=new Category(2,"Womens");
		
		Category c2=new Category(3,"Home appliences");
		
		Category c3=new Category(4,"Beuty products");
		
		session.save(c);session.save(c1);session.save(c2);session.save(c3);
		
		tx.commit();
		System.out.println("categories saved..");
		session.close();
	}
	void fetchCategory()
	{
		Session session=factory.openSession();
		System.out.println("----------Retrive categoty data from table using HQL----------");
		
		
		//from category
		//from category c
		
		
		Query q=session.createQuery("from Category");
		List<Category>list=q.list();
		for(Category cat:list)
		{
			System.out.println(cat.getId()+" "+cat.getName());
		}
		session.close();
	}
	
	void updateCategory()
	{
		//update Query
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("-------------update data from category--------------");
		
		Query q1=session.createQuery("update Category set name=name where id=:id");
		q1.setParameter("name","Women's sarees");
		q1.setParameter("id",2);
		q1.executeUpdate();
		tx.commit();
		System.out.println("data updated----------------");
		session.close();
	}
	void deleteCategory()
	{
		//delete Query
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("-------------delete data from category--------------");
		Query q2=session.createQuery("delete from Category where id=:id");
		q2.setParameter("id",3);
		q2.executeUpdate();
		tx.commit();
		System.out.println("deleted data----------------");
	}
	void pagination()
	{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		//Example of HQL to get records with pagination
		Query query=session.createQuery("from Category");
		query.setFirstResult(1);//1 is index
		query.setMaxResults(10);
		List<Category>list=query.list();//will return records from 2 to 10th number
		for(Category cat:list)
		{
			System.out.println(cat.getId()+" "+cat.getName());
		}
		session.close();	
	}
	public static void main(String[]args) {
		BasicOperation b=new BasicOperation();
		b.saveCategory();
		b.fetchCategory();
		
		System.out.println("-------------update record--------------");
		b.updateCategory();
		b.fetchCategory();
		
		System.out.println("-------------pagination--------------");
		b.pagination();
		
		System.out.println("-------------delete record--------------");
		b.deleteCategory();
		
		b.fetchCategory();
	}

}
