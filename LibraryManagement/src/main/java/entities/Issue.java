package entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Issue")
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Issue_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "Book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "Memb_id")
	private Member member;

	@Column(name = "Issue_date")
	private LocalDate issueDate;

	@Column(name = "Due_date")
	private LocalDate dueDate;

	@Column(name = "Return_date")
	private LocalDate returnDate;

	@Column(name = "Fine_amount")
	private double fine;

	public Issue(int id, Book book, Member member, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate,
			double fine) {
		super();
		this.id = id;
		this.book = book;
		this.member = member;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}

	public Issue() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}
}
