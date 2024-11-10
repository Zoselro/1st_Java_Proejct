package com.project.book;

public class BookVO {

	private int bookid;
	private String bookname;
	private String genre;
	private String writer;
	private String price;
	private String date;
	private String booktype;
	
	public BookVO() {
	
	}

	public BookVO(int bookid, String booktype) {
		super();
		this.bookid = bookid;
		this.booktype = booktype;
	}

	public BookVO(String bookname, String genre, String writer, String price, String booktype) {
		super();
		this.bookname = bookname;
		this.genre = genre;
		this.writer = writer;
		this.price = price;
		this.booktype = booktype;
	}

	

	public BookVO(int bookid, String bookname, String genre, String writer, String price, String date, String booktype) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.genre = genre;
		this.writer = writer;
		this.price = price;
		this.date = date;
		this.booktype = booktype;
	}

	public int getBookid() {
		return bookid;
	}

	public BookVO(String bookname, String booktype) {
		super();
		this.bookname = bookname;
		this.booktype = booktype;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
		return "책 번호 - " + bookid + " 책 제목 - " + bookname + " 책 장르 - " + genre + " 작가 - " + writer
				+ " 책 가격 - " + price + " 출판일자 - " + date + " 책 타입 - " + booktype + " ";
	}
	









}
