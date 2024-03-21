package entities;

import jakarta.persistence.*;
import java.util.Date;

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
	private Date issueDate;

	@Column(name = "Due_date")
	private Date dueDate;

	@Column(name = "Return_date")
	private Date returnDate;

	public Issue(int id, Book book, Member member, Date issueDate, Date dueDate, Date returnDate) {
		super();
		this.id = id;
		this.book = book;
		this.member = member;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
	}

	public Issue() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
}
