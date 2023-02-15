package com.yesdosoft.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb1PhoneNo")
public class PhoneNo {

	@Id
	private Integer phone_Id;
	
	private String phone_No;
	
	private String phone_Type;
	
	public PhoneNo ( ) {}
	
     //getter and setters

	public Integer getPhone_Id() {
		return phone_Id;
	}

	public void setPhone_Id(Integer phone_Id) {
		this.phone_Id = phone_Id;
	}

	public String getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}

	public String getPhone_Type() {
		return phone_Type;
	}

	public void setPhone_Type(String phone_Type) {
		this.phone_Type = phone_Type;
	}
	
}
	
	
