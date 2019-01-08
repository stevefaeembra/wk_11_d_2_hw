import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestLibrary {

	private Library library;
	private Book pride, catch22;
	private Borrower customer;

	@Before
	public void setUp() {
		customer = new Borrower("Steve");
		library = new Library(50);
		pride = new Book("Pride and Prejudice", "Jane Austen", "Romance");
		catch22 = new Book("Catch 22", "Joseph Heller", "Satire");
	}

	@Test
	public void hasCapacity() {
		assertEquals(50,library.getCapacity());
	}

	@Test
	public void hasBookCollection() {
		assertEquals(0,library.getStockLevels());
	}

	@Test
	public void canAddBook() {
		library.addNewBook(pride);
		assertEquals(1, library.getStockLevels());
	}

	@Test
	public void cannotAddOverCapacity() {
		for (int i=0; i<library.getCapacity(); i++) {
			library.addNewBook(pride);
		}
		library.addNewBook(pride);
		assertEquals(50, library.getStockLevels());
	}

	@Test
	public void lendOutBook() {
		library.addNewBook(pride);
		library.addNewBook(catch22);
		library.lendBook(catch22, customer);
		assertEquals(1, customer.getLoanedBooks().size());
		assertEquals(1, library.getStockLevels());
		assertEquals(pride, library.getStock().get(0));
		assertEquals(catch22, customer.getLoanedBooks().get(0));
	}

	@Test
	public void checkGenreTracking() {
		Book book1 = new Book("book1","author1", "comedy");
		Book book2 = new Book("book2","author2", "drama");
		Book book3 = new Book("book3","author2", "drama");
		Book book4 = new Book("book4","author3", "drama");
		Book book5 = new Book("book5","author4", "romance");
		Book book6 = new Book("book6","author5", "romance");
		Book book7 = new Book("book7","author6", "romance");
		Book book8 = new Book("book8","author7", "non-fiction");
		Book book9 = new Book("book9","author7", "non-fiction");
		Book book10 = new Book("book10","author7", "crime");
		library.addNewBook(book1);
		library.addNewBook(book2);
		library.addNewBook(book3);
		library.addNewBook(book4);
		library.addNewBook(book5);
		library.addNewBook(book6);
		library.addNewBook(book7);
		library.addNewBook(book8);
		library.addNewBook(book9);
		library.addNewBook(book10);
		assertEquals(10, library.getStockLevels());
		assertEquals(3, library.getQuantityOfGenre("drama"));
		assertEquals(3, library.getQuantityOfGenre("romance"));
		assertEquals(1, library.getQuantityOfGenre("comedy"));
		assertEquals(1, library.getQuantityOfGenre("crime"));
		assertEquals(2, library.getQuantityOfGenre("non-fiction"));
		assertEquals(0, library.getQuantityOfGenre("monkey tennis"));
		// now make sure it also gets updated if we loan out a book!
		library.lendBook(book10, customer); // no crime left
		library.lendBook(book2, customer); // down to 2 drama
		assertEquals(0, library.getQuantityOfGenre("crime"));
		assertEquals(2, library.getQuantityOfGenre("drama"));
	}

}
