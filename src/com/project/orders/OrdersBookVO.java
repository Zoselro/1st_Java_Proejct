package com.project.orders;

public class OrdersBookVO {
	private int orderid;
	private String id;
	private String bookname;
	private String date;
	private String booktype;
	
	
	
	public OrdersBookVO(String id) {
		super();
		this.id = id;
	}



	public OrdersBookVO() {
		super();
	}



	public OrdersBookVO(String id, String bookname, String booktype) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.booktype = booktype;
	}
	
	

	public OrdersBookVO(int orderid, String id, String bookname, String date, String booktype) {
		this.orderid = orderid;
		this.id = id;
		this.bookname = bookname;
		this.date = date;
		this.booktype = booktype;
	}



	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	@Override
	public String toString() {
		return "[orderid=" + orderid + ", 아이디 : " + id + ", 구매한 책 이름 : " + bookname + ", 책 타입 : " + booktype + "]";
	}
	
	
	
}
