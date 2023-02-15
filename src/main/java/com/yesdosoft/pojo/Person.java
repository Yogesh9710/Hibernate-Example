package com.yesdosoft.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb1Person")
public class Person {
	@Id
	private Integer pid;
	
	private String pname;
	
	@OneToMany(cascade=CascadeType.ALL)
	//will create new table name as person_phone and having colm pid phone_id
	@JoinTable(name="person_phone",joinColumns= {@JoinColumn(name="pid")},
	inverseJoinColumns= {@JoinColumn(name="phone_id")})
	private Set<PhoneNo>phone=new HashSet<PhoneNo>();
	
	public Person (){}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set<PhoneNo> getPhone() {
		return phone;
	}

	public void setPhone(Set<PhoneNo> phone) {
		this.phone = phone;
	}
	
	

}
