package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Book_id")
	private int id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Author")
	private String author;

	@ManyToOne
	@JoinColumn(name = "Pub_ID")
	private Publisher publisher;

	@Column(name = "Price")
	private double price;

	@Column(name = "Available")
	private String available;

	public Book() {
		super();
	}

	public Book(int id, String title, String author, Publisher publisher, double price, String available) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String isAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
}
