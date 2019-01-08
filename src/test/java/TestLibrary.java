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

}
