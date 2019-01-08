import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestLibrary {

	private Library library;
	private Book pride;

	@Before
	public void setUp() {
		library = new Library(50);
		pride = new Book("Pride and Prejudice", "Jane Austen", "Romance");
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
}
