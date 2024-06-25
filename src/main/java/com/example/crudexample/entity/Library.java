package com.example.crudexample.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="library")
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name ="Book Id")
	private int Bookid;
	
	@Column(name ="Book Name")
	private String Bookname;
	
	@Column(name ="Author")
	private String Author;
	
	@Column(name="Price")
	private double Price;

	public int getBookid() {
		return Bookid;
	}
   
	public Library() {
    }

	public void setBookid(int bookid) {
		Bookid = bookid;
	}

	public String getBookname() {
		return Bookname;
	}

	public void setBookname(String bookname) {
		Bookname = bookname;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public static List<Library> findAll() {
		return null;
	}

	public Library(int bookid, String bookname, String author, double price) {
		super();
		Bookid = bookid;
		Bookname = bookname;
		Author = author;
		Price = price;
	}
}
