package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Book;
import entities.Issue;
import entities.Member;
import entities.Publisher;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;

public class LibraryDAO {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void issueBook(int memberId, int bookId, Date issueDate, Date dueDate) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();

			Book book = session.get(Book.class, bookId);
			Member member = session.get(Member.class, memberId);

			if (book.isAvailable() == "YES") {
				Issue issue = new Issue();
				issue.setBook(book);
				issue.setMember(member);
				issue.setIssueDate(issueDate);
				issue.setDueDate(dueDate);

				session.persist(issue);

				book.setAvailable("NO");
				session.update(book);

				transaction.commit();
				System.out.println("Book issued successfully.");
			} else {
				System.out.println("Book is not available for issuing.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void returnBook(int issueId, Date returnDate) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();

			Issue issue = session.get(Issue.class, issueId);
			Book book = issue.getBook();

			issue.setReturnDate(returnDate);
			session.update(issue);

			book.setAvailable("YES");
			session.update(book);

			transaction.commit();
			System.out.println("Book returned successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addMember(Member member) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(member);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addPublisher(Publisher publisher) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(publisher);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addBook(Book book) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(book);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Publisher getPublisherById(int publisherId) {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Publisher> criteriaQuery = builder.createQuery(Publisher.class);
			Root<Publisher> root = criteriaQuery.from(Publisher.class);
			criteriaQuery.select(root).where(builder.equal(root.get("id"), publisherId));
			return session.createQuery(criteriaQuery).uniqueResult();
		} catch (Exception e) {
			System.err.println("Error occurred while fetching publisher by ID: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
