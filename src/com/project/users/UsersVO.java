package com.project.users;

import java.util.ArrayList;
import java.util.Scanner;

public class UsersVO {
	private int usernum;
	private String id;
	private String pw;
	private String name;
	private String rrn;
	private String email;
	private String phone;
	private String address;

	
	
	public UsersVO() {}

	


	public UsersVO(String id) {
		super();
		this.id = id;
	}




	public UsersVO(String id, String pw, String name, String rrn) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.rrn = rrn;
	}



	public UsersVO(String id, String pw, String name, String rrn, String email, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.rrn = rrn;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public UsersVO(String id, String pw, String name, String rrn, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.rrn = rrn;
		this.phone = phone;
	}

	
	public UsersVO(int usernum, String id, String pw, String name, String rrn, String email, String phone, String address) {
		super();
		this.usernum = usernum;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.rrn = rrn;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public int getUsernum() {
		return usernum;
	}

	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAdd(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "[아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 주민번호 : " + rrn + ", 이메일 : " + email + ", 휴대폰 번호 : "
				+ phone + ", 주소 : " + address + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
