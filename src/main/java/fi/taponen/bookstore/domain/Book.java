package fi.taponen.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // for MariaDB; H2 = strategy=GenerationType.AUTO
	private long id;
	
	@Size(min=1, max=250)
	private String title;
	
	@Size(min=2, max=250)
	private String author;
	private String isbn;
	private double price;
	private int year;
	
	@ManyToOne
	@JsonIgnore
	//@JsonManagedReference
	@JoinColumn(name="categoryId")
	//@NotNull
	private Category category;
	
	public Book() {
		super();
	}

	public Book(String title, String author, String isbn, double price, int year, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.year = year;
		this.category = category;
	}

	public Book(String title, String author, String isbn, double price, int year) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.year = year;
	}
	

	public Book(String title, String author, String isbn, int year) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
	}
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
		
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", year=" + year + ", category=" + category + "]";
	}
	
	
	
}
