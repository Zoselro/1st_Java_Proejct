package com.project.admin;

public class AdminVO {
	String codenumber;
	String password;
	String name;

	public AdminVO(String codenumber, String password, String name) {
		super();
		this.codenumber = codenumber;
		this.password = password;
		this.name = name;
	}
	
	public AdminVO(String codenumber, String password) {
		super();
		this.codenumber = codenumber;
		this.password = password;
	}
	public AdminVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodenumber() {
		return codenumber;
	}

	public void setCodenumber(String codenumber) {
		this.codenumber = codenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AdminVO [codenumber=" + codenumber + ", password=" + password + ", name=" + name + "]";
	}

	

}
