import java.util.Scanner;

import dao.LibraryDAO;
import entities.Book;
import entities.Member;
import entities.MemberType;
import entities.Publisher;

import java.util.Date;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("1. Issue Book\n2. Return Book\n3. Add Member\n4. Add Publisher\n5. Add Book\n6. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

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
		scanner.nextLine(); // Consume newline

		// Get issue date and due date
		Date issueDate = new Date();
		Date dueDate = new Date(issueDate.getTime() + 7 * 24 * 60 * 60 * 1000); // Due date after 7 days

		LibraryDAO.issueBook(memberId, bookId, issueDate, dueDate);
	}

	private static void returnBook(Scanner scanner) {
		System.out.print("Enter issue ID: ");
		int issueId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		// Get return date
		Date returnDate = new Date();

		LibraryDAO.returnBook(issueId, returnDate);
	}

	private static void addMember(Scanner scanner) {
		System.out.print("Enter member name: ");
		String name = scanner.nextLine();
		System.out.print("Enter member type (Student/Faculty/Staff): ");
		String memberType = scanner.nextLine();
		System.out.print("Enter member address: ");
		String address = scanner.nextLine();
		
		// Create member object
		Member member = new Member();
		member.setName(name);
		member.setMemberType(MemberType.valueOf(memberType));
		member.setAddress(address);
		member.setExpiryDate();
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
		System.out.print("Enter book title: ");
		String title = scanner.nextLine();
		System.out.print("Enter book author: ");
		String author = scanner.nextLine();
		System.out.print("Enter book publisher ID: ");
		int publisherId = scanner.nextInt();
		System.out.print("Enter book price: ");
		double price = scanner.nextDouble();
		scanner.nextLine(); // Consume newline
		System.out.print("Is the book available? (true/false): ");
		boolean available = scanner.nextBoolean();
		scanner.nextLine(); // Consume newline

		// CHECK
		String flag = "YES";
		if (available) {
			flag = "YES";
		} else {
			flag = "NO";
		}

		// Fetch the Publisher entity from the database using the publisherId
		Publisher publisher = LibraryDAO.getPublisherById(publisherId);

		// Create book object
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setAvailable(flag);

		LibraryDAO.addBook(book);
		System.out.println("Book added successfully.");
	}
}
