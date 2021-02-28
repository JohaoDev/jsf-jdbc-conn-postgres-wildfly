package com.project3.com;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Users implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private String name = "";
	private String lastname = "";

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String saveData() {
		ConnDB.initConn();
		ConnDB.postData(name, lastname);
		return "index2.xhtml?faces-redirect=true";
	}
}
