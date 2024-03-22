package main;

import java.util.Scanner;

import dao.LibraryDAO;
import entities.Author;
import entities.Book;
import entities.Member;
import entities.MemberType;
import entities.Publisher;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("1. Issue Book\n2. Return Book\n3. Add Member\n4. Add Publisher\n5. Add Book\n6. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				issueBook(scanner);
				break;
			case 2:
				returnBook(scanner);
				break;
			case 3:
				addMember(scanner);
				break;
			case 4:
				addPublisher(scanner);
				break;
			case 5:
				addBook(scanner);
				break;
			case 6:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}

		scanner.close();
	}

	private static void issueBook(Scanner scanner) {
		System.out.print("Enter member ID: ");
		int memberId = scanner.nextInt();
		System.out.print("Enter book ID: ");
		int bookId = scanner.nextInt();
		scanner.nextLine();
		double fine =0;
		
		// Get issue date
		LocalDate issueDate = LocalDate.now();

		// Calculate due date using Period
		Period oneWeek = Period.ofDays(7);
		LocalDate dueDate = issueDate.plus(oneWeek);
		
		// Calculate fine if overdue
	    fine = calculateFine(dueDate);

		LibraryDAO.issueBook(memberId, bookId, issueDate, dueDate,fine);
	}
	
	private static double calculateFine(LocalDate dueDate) {
	    // Calculate the number of days overdue
	    LocalDate currentDate = LocalDate.now();
	    long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);

	    // If the book is not overdue, fine is 0
	    if (daysOverdue <= 0) {
	        return 0;
	    }

	    // Fine is Rs. 1 for each day overdue
	    return daysOverdue;
	}

	private static void returnBook(Scanner scanner) {
		System.out.print("Enter issue ID: ");
		int issueId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		// Get return date
		LocalDate returnDate = LocalDate.now();

		LibraryDAO.returnBook(issueId, returnDate);
	}

	private static void addMember(Scanner scanner) {
		System.out.print("Enter member name: ");
		String name = scanner.nextLine();
		System.out.print("Enter member type (Student/Faculty/Staff): ");
		String memberType = scanner.nextLine();
		System.out.print("Enter member address: ");
		String address = scanner.nextLine();
		System.out.print("Enter MailId/PhoneNo: ");
		String contact = scanner.nextLine();

		// Create member object
		Member member = new Member();
		member.setName(name);
		member.setMemberType(MemberType.valueOf(memberType));
		member.setAddress(address);
		member.setExpiryDate();
		member.setContact(contact);
		LibraryDAO.addMember(member);
		System.out.println("Member added successfully.");
	}

	private static void addPublisher(Scanner scanner) {
		System.out.print("Enter publisher name: ");
		String name = scanner.nextLine();
		System.out.print("Enter publisher address: ");
		String address = scanner.nextLine();

		// Create publisher object
		Publisher publisher = new Publisher();
		publisher.setName(name);
		publisher.setAddress(address);

		LibraryDAO.addPublisher(publisher);
		System.out.println("Publisher added successfully.");
	}

	private static void addBook(Scanner scanner) {
		System.out.print("Enter author name: ");
		String authorName = scanner.nextLine();
		System.out.print("Enter book name: ");
		String bookName = scanner.nextLine();
		System.out.print("Enter published year: ");
		int publishedYear = scanner.nextInt();
		scanner.nextLine();
		Author author = new Author(authorName, bookName, publishedYear);

		System.out.print("Enter book publisher ID: ");
		int publisherId = scanner.nextInt();
		System.out.print("Enter book price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Is the book available? (true/false): ");
		boolean available = scanner.nextBoolean();
		scanner.nextLine();

		// Fetch the Publisher entity from the database using the publisherId
		Publisher publisher = LibraryDAO.getPublisherById(publisherId);

		// Create book object
		Book book = new Book();
		book.setTitle(bookName);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setAuthor(authorName);
		book.setAvailable(available ? "YES" : "NO");

		LibraryDAO.addBook(book, author);
	}
	
}
