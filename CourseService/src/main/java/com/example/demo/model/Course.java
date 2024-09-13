package com.example.demo.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
@Entity
public class Course
{
	@Id
	private int cid;
	private String cname;
	private String courseduration;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getduration() {
		return courseduration;
	}
	public void setDuration(String courseduration) {
		this.courseduration = courseduration;
	}
	
	

}

